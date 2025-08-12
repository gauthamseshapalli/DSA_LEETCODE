class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // minCap = largest element, maxCap = sum of all weights
        int minCap = 0;
        int maxCap = 0;

        for (int w : weights) {
            maxCap += w;
            minCap = Math.max(minCap, w);
        }

        int low = minCap;
        int high = maxCap;

        while (low <= high) {
            int mid = (low + high) / 2;
            int neededDays = 1;
            int load = 0;

            for (int w : weights) {
                if (load + w > mid) {
                    neededDays++;
                    load = w;
                } else {
                    load += w;
                }
            }

            if (neededDays <= days) {
                high = mid - 1; // try smaller capacity
            } else {
                low = mid + 1; // need larger capacity
            }
        }

        return low; // smallest capacity that works
    }
}
