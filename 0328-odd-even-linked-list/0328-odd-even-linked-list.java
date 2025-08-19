/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

        class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;              // 1st node (odd index)
        ListNode even = head.next;        // 2nd node (even index)
        ListNode evenHead = even;         // store start of even list

        // Traverse the list
        while (even != null && even.next != null) {
            odd.next = even.next;         // link odd → next odd
            odd = odd.next;

            even.next = odd.next;         // link even → next even
            even = even.next;
        }

        // connect odd list with even list
        odd.next = evenHead;

        return head;
    }
}
