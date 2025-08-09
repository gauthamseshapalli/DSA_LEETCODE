class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while (low < high) {
            int mid = (low + high) / 2;
            int hours = getHours(piles, mid);

            if (hours <= h) {
                high = mid; 
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int findMax(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }

    private int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; 
        }
        return hours;
    }
}
