package algorithm.leetcode;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解题思路：任意选中一个结点当作非最短的链表的头，发现选中的链表是最短的时候，通过操作next指针，将另一条链表的元素转移到选中的链表上来。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            throw new RuntimeException();
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int current = 0;
        int next = 0;

        ListNode result = l1;

        while (true) {
            int sum = l1.val + l2.val + next;
            current = sum % 10;
            next = sum / 10;

            l1.val = current;

            if (l1.next == null) {
                // 发现选中的链表并不是非最短的，尝试将l2后续元素转移到l1上
                if (l2.next != null) {
                    l1.next = l2.next;
                    l2.next = null;
                } else {
                    if (next == 0) {
                        break;
                    }
                    l1.next = new ListNode(next);
                    break;
                }
            }
            if (l2.next == null) {
                if (next == 0) {
                    break;
                }
                // 处理进位，把进位虚构成一个节点再加到l2上
                l2.next = new ListNode(next);
                next = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return result;
    }
}
