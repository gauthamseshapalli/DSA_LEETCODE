class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long count = 0;

        for (int num : nums) {
            if (num == 0) {
                count++;
                result += count; // add all subarrays ending at this zero
            } else {
                count = 0; // reset when non-zero found
            }
        }

        return result;
    }
}
