/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        if (headA == null || headB == null)
            return null;
        // Store all nodes of list A
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }

        // Traverse list B and check for intersection
        curr = headB;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr; // Intersection found
            }
            curr = curr.next;
        }

        return null; // No intersection

    }
}