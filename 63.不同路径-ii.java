/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = 1;
                    continue;
                }

                int t = 0;
                if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                    t += result[i - 1][j];
                }
                if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                    t += result[i][j - 1];
                }
                result[i][j] = t;
            }
        }

        return result[m - 1][n - 1];
    }
}
// @lc code=end

