class Solution {
    public String smallestNumber(String num, long t) {
        long[] need = new long[8];
        for (int p : new int[]{2,3,5,7})
            while (t % p == 0) { t /= p; need[p]++; }
        if (t != 1) return "-1";

        int n = num.length();
        long[] prefix = new long[8];
        int firstZero = n;

        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            if (d == 0 && firstZero == n) firstZero = i;
            addDigit(prefix, d); // always accumulate (0 adds nothing anyway)
        }
        if (firstZero == n && covers(prefix, need)) return num;

        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            removeDigit(prefix, d);
            if (i > firstZero) continue;
            int tail = n - 1 - i;
            for (int nd = d + 1; nd < 10; nd++) {
                String rest = buildRest(subtract(subtract(need, prefix), nd), tail);
                if (rest != null)
                    return num.substring(0, i) + nd + rest;
            }
        }

        String rest = buildMin(need);
        int totalLen = Math.max(n + 1, rest.length());
        return "1".repeat(totalLen - rest.length()) + rest;
    }

    private void addDigit(long[] c, int d) {
        if (d==2||d==4||d==6||d==8) c[2] += (d==2?1:d==4?2:d==6?1:3);
        if (d==3||d==6||d==9)       c[3] += (d==3?1:d==6?1:2);
        if (d==5)                   c[5]++;
        if (d==7)                   c[7]++;
    }

    private void removeDigit(long[] c, int d) {
        long[] tmp = new long[8];
        addDigit(tmp, d);
        for (int p : new int[]{2,3,5,7}) c[p] = Math.max(0, c[p] - tmp[p]);
    }

    private long[] subtract(long[] a, long[] b) {
        long[] r = a.clone();
        for (int p : new int[]{2,3,5,7}) r[p] = Math.max(0, r[p] - b[p]);
        return r;
    }

    private long[] subtract(long[] a, int d) {
        long[] tmp = new long[8]; addDigit(tmp, d);
        return subtract(a, tmp);
    }

    private boolean covers(long[] have, long[] need) {
        for (int p : new int[]{2,3,5,7}) if (have[p] < need[p]) return false;
        return true;
    }

    private String buildMin(long[] need) {
        int c8=(int)(need[2]/3), r2=(int)(need[2]%3);
        int c9=(int)(need[3]/2), c3=(int)(need[3]%2);
        int c4=r2/2, c2=r2%2, c6=0;
        if (c2==1&&c3==1) { c2=0; c3=0; c6=1; }
        if (c3==1&&c4==1) { c2=1; c6=1; c3=0; c4=0; }
        return "2".repeat(c2)+"3".repeat(c3)+"4".repeat(c4)
              +"5".repeat((int)need[5])+"6".repeat(c6)
              +"7".repeat((int)need[7])+"8".repeat(c8)+"9".repeat(c9);
    }

    private String buildRest(long[] remaining, int space) {
        String min = buildMin(remaining);
        if (min.length() > space) return null;
        return "1".repeat(space - min.length()) + min;
    }
}
