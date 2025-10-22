class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int el = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                el = nums[i];
                count++;

            } else if (el == nums[i]) {
                count++;
            } else {
                count--;
            }

        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (el == nums[i]) {
                counter++;
            }

        }

        if (counter > n / 2) {
            return el;
        } else {
            return -1;
        }
    }
}