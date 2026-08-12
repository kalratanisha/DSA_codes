class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int m = h.length, n = h[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(h, p, i, 0);
            dfs(h, a, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(h, p, 0, j);
            dfs(h, a, m - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (p[i][j] && a[i][j])
                    ans.add(Arrays.asList(i, j));

        return ans;
    }

    void dfs(int[][] h, boolean[][] vis, int r, int c) {
        if (vis[r][c]) return;

        vis[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int x = r + dr[k], y = c + dc[k];

            if (x >= 0 && x < h.length && y >= 0 && y < h[0].length
                    && !vis[x][y] && h[x][y] >= h[r][c])
                dfs(h, vis, x, y);
        }
    }
}