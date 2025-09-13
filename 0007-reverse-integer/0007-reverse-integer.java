class Solution {
    public int reverse(int x) {

        long reverseNumber = 0;

        while (x != 0) {
            int ld = x % 10;

            reverseNumber = (reverseNumber * 10) + ld;

            x = x / 10;

        }
        if (reverseNumber > Integer.MAX_VALUE || reverseNumber < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverseNumber;
    }
}
