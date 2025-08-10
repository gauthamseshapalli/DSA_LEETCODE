class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
      
        if (n > threshold) return -1;

        int maxNum = 0;
        for (int num : nums) maxNum = Math.max(maxNum, num);

        int low = 1, high = maxNum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumByDivisor(nums, mid, threshold) <= threshold) {
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return low;
    }

    // Helper that returns the sum of ceil(nums[i] / divisor).
    // Stops early if sum exceeds threshold.
    private int sumByDivisor(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // integer ceil
            if (sum > threshold) return sum; // early exit
        }
        return sum;
    }
}
