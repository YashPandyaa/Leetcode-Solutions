class Solution {
    int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};

    public boolean findSafeWalk(List<List<Integer>> mat, int health) {

        int m = mat.size();
        int n = mat.get(0).size();

        int[][] grid = mat.stream()
                .map(inner -> inner.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{grid[0][0], 0, 0});
        grid[0][0] = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (x == m - 1 && y == n - 1) {
                return cost < health;
            }

            for (int[] d : dir) {

                int r = x + d[0];
                int c = y + d[1];

                if (r < 0 || r >= m || c < 0 || c >= n)
                    continue;

                if (grid[r][c] == Integer.MAX_VALUE)
                    continue;

                int nextCost = cost + grid[r][c];

                if (nextCost < health) {
                    pq.offer(new int[]{nextCost, r, c});
                    grid[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        return false;
    }
}
