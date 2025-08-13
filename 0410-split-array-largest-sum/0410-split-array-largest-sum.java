class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            high += num;          // total sum
            low = Math.max(low, num); // at least the largest single element
        }

        while (low < high) {  // use <, not <=
            int mid = low + (high - low) / 2;

            if (canSplit(nums, mid, k)) {
                high = mid; // try smaller max sum
            } else {
                low = mid + 1; // need bigger max sum
            }
        }

        return low; // low == high here
    }

    private boolean canSplit(int[] nums, int maxSumAllowed, int k) {
        int pieces = 1;
        int currSum = 0;

        for (int num : nums) {
            if (currSum + num > maxSumAllowed) {
                pieces++;
                currSum = num;
                if (pieces > k) return false;
            } else {
                currSum += num;
            }
        }
        return true;
    }
}
