class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Step 1: Extract values into arrays
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        while (l1 != null) {
            arr1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            arr2.add(l2.val);
            l2 = l2.next;
        }
        
        // \U0001f6ab Step 2: Do NOT reverse arrays, because lists are already reversed in LeetCode
        
        // Step 2: Add numbers digit by digit
        int i = 0, j = 0, carry = 0;
        List<Integer> result = new ArrayList<>();
        
        while (i < arr1.size() || j < arr2.size() || carry != 0) {
            int x = (i < arr1.size()) ? arr1.get(i) : 0;
            int y = (j < arr2.size()) ? arr2.get(j) : 0;
            
            int total = x + y + carry;
            carry = total / 10;
            result.add(total % 10);
            
            i++;
            j++;
        }
        
        // Step 3: Build linked list (result is already in reverse order)
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int digit : result) {
            curr.next = new ListNode(digit);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
