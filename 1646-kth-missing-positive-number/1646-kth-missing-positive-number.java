class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;  // missing count
        int num = 1;    // current number
        int i = 0;      // index in arr

        while (true) {
            if (i < arr.length && arr[i] == num) {
                i++; // skip if number is in arr
            } else {
                count++;
                if (count == k) return num;
            }
            num++;
        }
    }
}
