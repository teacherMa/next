package algorithm.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode build(int[] input) {
        int length = input.length;
        ListNode fake = new ListNode(-1);
        ListNode head = new ListNode(input[0]);
        fake.next = head;
        for (int i = 1; i < length; i++) {
            head.next = new ListNode(input[i]);
            head = head.next;
        }
        return fake.next;
    }
}
