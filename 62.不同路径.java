/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[0][0] = 1;
                    continue;
                }
                int t = 0;
                if (i > 0) {
                    t += result[i - 1][j];
                }
                if (j > 0) {
                    t += result[i][j - 1];
                }
                result[i][j] = t;
            }
        }

        return result[m - 1][n - 1];
    }
}
// @lc code=end

