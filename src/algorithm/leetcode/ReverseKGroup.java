package algorithm.leetcode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode test = ListNode.build(new int[]{1, 2, 3, 4, 5});
        new ReverseKGroup().reverseKGroup(test, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode current = fake;
        ListNode nextHead = head;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (nextHead == null) {
                    break;
                }
                nextHead = nextHead.next;
            }
            ListNode[] result = reverseList(head, k);
            if (result == null || result.length < 1) {
                break;
            }
            current.next = result[0];
            if (result.length == 1) {
                break;
            } else if (result.length == 2) {
                current = result[1];
            }
            head = nextHead;
        }
        return fake.next;
    }

    /**
     * @return 第0个元素表示反转后的头，第1个元素表示反转后的尾
     */
    private ListNode[] reverseList(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode cur = fake;

        for (int i = 0; i < k; i++) {
            cur = cur.next;
            if (cur == null) {
                // 探测是否有足够多的节点供翻转
                return new ListNode[]{head};
            }
        }

        ListNode tail = null;
        cur = head;
        ListNode next = cur.next;

        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return null;
            }
            cur.next = tail;
            tail = cur;
            cur = next;
            if (cur != null) {
                next = cur.next;
            }
        }
        return new ListNode[]{tail, head};
    }
}
