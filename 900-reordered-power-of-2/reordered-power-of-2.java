class Solution {

    public boolean reorderedPowerOf2(int n) {
        int[] countN = countDigits(n);

        // Check all powers of two
        for (int i = 0; i <= 30; i++) {
            int power = 1 << i;
            if (matches(countN, countDigits(power))) {
                return true;
            }
        }
        return false;
    }

    // Count digits of a number
    private int[] countDigits(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }

    // Compare two digit-frequency arrays
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
