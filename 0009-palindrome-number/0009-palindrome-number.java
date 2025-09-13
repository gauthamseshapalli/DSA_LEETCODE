class Solution {
    public boolean isPalindrome(int x) {
        int duplicate = x;
        int revNum = 0;
        int ld = 0;

        while (x != 0) {
            ld = x % 10;

            revNum = (revNum * 10) + ld;

            x = x / 10;
        }
        if (duplicate < 0) {
            return false;
        }
        if (duplicate == revNum) {
            return true;
        } else {
            return false;

        }
    }
}