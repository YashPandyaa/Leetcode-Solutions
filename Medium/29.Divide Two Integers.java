class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = false;
        if ((dividend < 0 && divisor > 0) ||
            (dividend > 0 && divisor < 0)) {
            negative = true;
        }

        long num = Math.abs((long) dividend);
        long div = Math.abs((long) divisor);

        int ans = 0;

        while (num >= div) {

            long value = div;
            int count = 1;

            while (num >= value + value) {
                value = value + value;
                count = count + count;
            }

            num = num - value;
            ans = ans + count;
        }

        if (negative) {
            return -ans;
        }

        return ans;
    }
}
