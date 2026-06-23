class Solution {
    int mod = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        for (int i = 2; i <= n; i++) {

            long[] predown = new long[m + 1];
            long[] suffup = new long[m + 1];

            for (int j = 0; j < m; j++) {
                predown[j + 1] = (predown[j] + down[j]) % mod;
            }

            for (int j = m - 1; j >= 0; j--) {
                suffup[j] = (suffup[j + 1] + up[j]) % mod;
            }

            long[] newup = new long[m];
            long[] newdown = new long[m];

            for (int j = 0; j < m; j++) {
                newup[j] = predown[j];
                newdown[j] = suffup[j + 1];
            }

            up = newup;
            down = newdown;
        }

        long ans = 0;

        for (int j = 0; j < m; j++) {
            ans = (ans + up[j] + down[j]) % mod;
        }

        return (int) ans;
    }
}
