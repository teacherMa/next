package algorithm.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new RemoveNthFromEnd().removeNthFromEnd(head, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        ListNode fake = new ListNode(0);
        current = fake;
        current.next = head;
        for (int i = 0; i < count - n; i++) {
            current = current.next;
        }
        ListNode before = current;
        current = current.next;
        if (current != null) {
            before.next = current.next;
        }
        return fake.next;
    }
}
