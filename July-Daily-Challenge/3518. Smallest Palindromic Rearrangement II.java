class Solution {
    private static final long LIMIT = 1000001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
                freq[i]--;
                break;
            }
        }

        int[] half = new int[26];
        int len = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];
        }

        if (countWays(half) < k) return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        String first = left.toString();
        String second = new StringBuilder(first).reverse().toString();

        if (mid == 0) return first + second;
        return first + mid + second;
    }

    private long countWays(int[] half) {
        int total = 0;
        for (int x : half) total += x;

        long ans = 1;

        for (int i = 0; i < 26; i++) {
            if (half[i] == 0) continue;

            ans *= combination(total, half[i]);

            if (ans >= LIMIT) return LIMIT;

            total -= half[i];
        }

        return ans;
    }

    private long combination(int n, int r) {
        if (r > n) return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans >= LIMIT) return LIMIT;
        }

        return ans;
    }
}
