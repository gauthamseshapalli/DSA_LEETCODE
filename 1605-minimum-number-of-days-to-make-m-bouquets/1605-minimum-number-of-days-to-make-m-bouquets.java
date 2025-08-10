class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long totalFlowersNeeded = (long) m * k;
        if (n < totalFlowersNeeded) return -1; // Impossible case

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find min and max bloom days
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                high = mid; // Try smaller days
            } else {
                low = mid + 1; // Need more days
            }
        }
        return low;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // Reset after making one bouquet
                }
            } else {
                flowers = 0; // Break in adjacency
            }
        }
        return bouquets >= m;
    }
}
