class Solution {

    private long countSmaller(long mid, int[] coins) {
        long correctedCount = 0;
        int n = coins.length;

        for (int expressions = 1; expressions <= (1 << n) - 1; expressions++) { 
            long lcm = 0;
            long order = 0; 

            for (int i = 0; i < n; i++) {
                if ((expressions & (1 << i)) != 0) {
                    order++; 

                    if (lcm == 0) {
                        lcm = coins[i];
                    } else {
                        lcm = lcm * coins[i] / gcd(lcm, coins[i]);
                    }
                }
            }

            if (order % 2 == 0) { 
                correctedCount -= mid / lcm;
            } else {
                correctedCount += mid / lcm;
            }
        }

        return correctedCount;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long findKthSmallest(int[] coins, int k) {
        long result = -1;

        int maxCoin = 0;
        for (int c : coins) maxCoin = Math.max(maxCoin, c);

        long l = 1;
        long r = (long) maxCoin * k;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (countSmaller(mid, coins) >= k) { 
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}
