package algorithm.leetcode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            throw new RuntimeException();
        }

        if (lists.length == 0) {
            return null;
        }

        int row = lists.length;
        ListNode[] oldLists = lists;
        ListNode[] newLists;
        while (row > 1) {
            newLists = new ListNode[(row + 1) / 2];
            for (int i = 0; i < row; i = i + 2) {
                ListNode tmp = mergeTwoLists(oldLists[i], i + 1 > row ? null : oldLists[i + 1]);
                newLists[i / 2] = tmp;
            }
            oldLists = newLists;
            row = oldLists.length;
        }
        return oldLists[0];
    }

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
