package leetcode.editor.cn;

//994.腐烂的橘子
public class OrangesRotting {
    public static void main(String[] args) {
        Solution solution = new OrangesRotting().new Solution();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}; //res=4
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}; //res=-1
        int[][] grid3 = {{0, 2}}; //res=0
        int res = solution.orangesRotting(grid);
        System.out.println(res);
    }

    class Solution {
        private int H, W;
        public int orangesRotting(int[][] grid) {
            H = grid.length;
            W = grid[0].length;
            int time = 0;
            boolean hasRotting = false;
            for (int i = 0; i < H; i++)
                for (int j = 0; j < W; j++)
                    if (grid[i][j] == 2) {
                        hasRotting = true;
                        dfs(grid, i, j, 2);
                    }
            for (int i = 0; i < H; i++)
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] == 1)
                        return -1;
                    time = Math.max(time, grid[i][j]);
                }
            if (!hasRotting) return 0;
            // 减去代表腐烂的 2
            return time - 2;
        }

        private void dfs(int[][] grid, int x, int y, int val) {
            grid[x][y] = val;
            if (x > 0 && (grid[x - 1][y] == 1 || val + 1 < grid[x - 1][y]))
                dfs(grid, x - 1, y, val + 1);
            if (x < H - 1 && (grid[x + 1][y] == 1 || val + 1 < grid[x + 1][y]))
                dfs(grid, x + 1, y, val + 1);
            if (y > 0 && (grid[x][y - 1] == 1 || val + 1 < grid[x][y - 1]))
                dfs(grid, x, y - 1, val + 1);
            if (y < W - 1 && (grid[x][y + 1] == 1 || val + 1 < grid[x][y + 1]))
                dfs(grid, x, y + 1, val + 1);
        }
    }
}
