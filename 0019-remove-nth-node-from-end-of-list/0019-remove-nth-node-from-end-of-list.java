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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //length

        int length=0;
        ListNode curr=head;

        while(curr!=null){
            length++;
            curr=curr.next;
        }

        //find the nth node which is to be removed

        int target=length-n;

        if (target == 0) {
            return head.next;
        }

        //go to the nth node

        curr=head;
       for(int i=1;i<target;i++){
        curr=curr.next;
       }
       //remove the target node

       curr.next=curr.next.next;


       return head;
    }
}