class Solution {
    int n;
    int[][] t = new int[501][501];

    private int solve(int[] piles, int i, int j) {
        if (i > j)
            return 0;

        if (t[i][j] != -1)
            return t[i][j];

        int choose_i = piles[i] + Math.min(solve(piles, i+2, j), solve(piles, i+1, j-1));
        int choose_j = piles[j] + Math.min(solve(piles, i, j-2), solve(piles, i+1, j-1));

        return t[i][j] = Math.max(choose_i, choose_j);
    }

    public boolean stoneGame(int[] piles) {
        n = piles.length;

        for (int[] row : t)
            Arrays.fill(row, -1);

        int sum = 0;
        for (int p : piles)
            sum += p;

        int alexScore = solve(piles, 0, n-1);

        return alexScore > sum/2;
    }
}
