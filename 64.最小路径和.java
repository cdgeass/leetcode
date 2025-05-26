/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = grid[i][j];
                    continue;
                }

                int v;
                if (i == 0) {
                    v = result[i][j - 1];
                } else if (j == 0) {
                    v = result[i - 1][j];
                } else {
                    v = Math.min(result[i][j - 1], result[i - 1][j]);
                }

                result[i][j] = v + grid[i][j];
            }
        }

        return result[m - 1][n - 1];
    }
}
// @lc code=end

