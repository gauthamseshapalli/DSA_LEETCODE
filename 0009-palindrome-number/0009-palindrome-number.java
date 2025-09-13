class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false; 

        long revNum = 0;
        int original = x;

        while (x != 0) {
            int ld = x % 10;
            revNum = revNum * 10 + ld;
            x /= 10;
        }

        return revNum == original;
    }
}
