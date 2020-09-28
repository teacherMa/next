package algorithm.leetcode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode i = l1;
        ListNode j = l2;
        ListNode fake = new ListNode(0);
        ListNode current = fake;
        while (true) {
            if (i == null) {
                current.next = j;
                break;
            }
            if (j == null) {
                current.next = i;
                break;
            }
            if (i.val < j.val) {
                current.next = i;
                i = i.next;
            } else {
                current.next = j;
                j = j.next;
            }
            current = current.next;

        }
        return fake.next;
    }
}
