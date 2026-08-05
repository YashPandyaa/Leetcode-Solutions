class Solution {
    boolean[] vis;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : invocations) {
            g[e[0]].add(e[1]);
        }

        vis = new boolean[n];
        dfs(k, g);

        for (int[] e : invocations) {
            if (!vis[e[0]] && vis[e[1]]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    void dfs(int u, List<Integer>[] g) {
        vis[u] = true;

        for (int v : g[u]) {
            if (!vis[v]) {
                dfs(v, g);
            }
        }
    }
}
