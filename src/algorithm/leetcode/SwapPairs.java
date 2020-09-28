package algorithm.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fake = new ListNode(0);
        fake.next = head;

        ListNode pre = fake;
        ListNode i = head;
        ListNode j = i.next;
        if (j == null) {
            return head;
        }

        while (true) {

            pre.next = j;
            i.next = j.next;
            j.next = i;

            pre = i;
            i = pre.next;
            if (i == null) {
                break;
            }
            j = i.next;
            if (j == null) {
                break;
            }
        }
        return fake.next;
    }
}
