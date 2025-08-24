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
    public ListNode sortList(ListNode head) {
     if (head == null || head.next == null) return head;

        ListNode mid = getMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null; // cut the list

        // Step 2: Sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // Step 3: Merge sorted halves
        return merge(left, right);
    }

    // Find the middle node (slow/fast pointer)
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
   
    }
}