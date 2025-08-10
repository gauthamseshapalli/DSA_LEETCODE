class Solution {
    public boolean canMake(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0; // reset after making one bouquet
                }
            } else {
                count = 0; // break in adjacency
            }
        }
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowersNeeded = (long) m * k;
        int n = bloomDay.length;
        if (totalFlowersNeeded > n)
            return -1;

        int minDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        int low = minDay, high = maxDay;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, mid, m, k)) {
                high = mid - 1; // try smaller days
            } else {
                low = mid + 1; // need more days
            }
        }
        return low;
    }
}
