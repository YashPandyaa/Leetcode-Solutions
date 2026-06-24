class Solution {
    int mod = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[][] t = new long[m][m];

        for (int j = 0; j < m; j++) {
            for (int i = m - j; i < m; i++) {
                t[i][j] = 1;
            }
        }

        long[][] powt = maTPow(t, n - 1, m);

        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                total = (total + powt[i][j]) % mod;
            }
        }

        return (int) (total * 2 % mod);
    }

    long[][] maTPow(long[][] base, long e, int m) {
        long[][] res = new long[m][m];
        for (int i = 0; i < m; i++) {
            res[i][i] = 1;
        }

        while (e > 0) {
            if ((e & 1) == 1) {
                res = mul(res, base);
            }

            base = mul(base, base);
            e >>= 1;
        }

        return res;
    }

    long[][] mul(long[][] a, long[][] b) {

        int m = a.length;
        long[][] c = new long[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                long sum = 0;
                for (int k = 0; k < m; k++) {
                    sum = (sum + a[i][k] * b[k][j]) % mod;
                }
                c[i][j] = sum;
            }
        }

        return c;
    }
}
