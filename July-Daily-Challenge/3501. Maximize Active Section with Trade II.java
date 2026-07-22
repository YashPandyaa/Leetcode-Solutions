class Group {
    public int start;
    public int length;
    public Group(int start, int length) {
        this.start = start;
        this.length = length;
    }
}

class SparseTable {
    public SparseTable(int[] nums) {
        n = nums.length;
        st = new int[bitLength(n) + 1][n + 1];
        System.arraycopy(nums, 0, st[0], 0, n);
        for (int i = 1; i < st.length; ++i)
            for (int j = 0; j + (1 << i) <= n; ++j)
                st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
    }

    public int query(int l, int r) {
        final int i = bitLength(r - l + 1) - 1;
        return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
    }

    private final int n;
    private final int[][] st;

    private int bitLength(int n) {
        return Integer.SIZE - Integer.numberOfLeadingZeros(n);
    }
}

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        final int n = s.length();
        final int ones = (int) s.chars().filter(c -> c == '1').count();

        final List<Group> zeroGroups = new ArrayList<>();
        final int[] zeroGroupIndex = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0')
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                else
                    zeroGroups.add(new Group(i, 1));
            }
            zeroGroupIndex[i] = zeroGroups.size() - 1;
        }

        if (zeroGroups.isEmpty())
            return Collections.nCopies(queries.length, ones);

        final int[] zeroMergeLengths = new int[zeroGroups.size() - 1];
        for (int i = 0; i < zeroGroups.size() - 1; ++i)
            zeroMergeLengths[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;

        final SparseTable st = new SparseTable(zeroMergeLengths);
        final List<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            final int l = query[0];
            final int r = query[1];

            final int left = zeroGroupIndex[l] == -1 ? -1
                    : (zeroGroups.get(zeroGroupIndex[l]).length
                       - (l - zeroGroups.get(zeroGroupIndex[l]).start));

            final int right = zeroGroupIndex[r] == -1 ? -1
                    : (r - zeroGroups.get(zeroGroupIndex[r]).start + 1);

            final int startAdj = zeroGroupIndex[l] + 1;
            final int endAdj   = (s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1) - 1;

            int activeSections = ones;

            if (s.charAt(l) == '0' && s.charAt(r) == '0'
                    && zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {
                activeSections = Math.max(activeSections, ones + left + right);
            } else if (startAdj <= endAdj) {
                activeSections = Math.max(activeSections, ones + st.query(startAdj, endAdj));
            }

            if (s.charAt(l) == '0'
                    && zeroGroupIndex[l] + 1 <= (s.charAt(r) == '1'
                            ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1)) {
                activeSections = Math.max(activeSections,
                        ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length);
            }

            if (s.charAt(r) == '0' && zeroGroupIndex[l] < zeroGroupIndex[r] - 1) {
                activeSections = Math.max(activeSections,
                        ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length);
            }

            ans.add(activeSections);
        }

        return ans;
    }
}
