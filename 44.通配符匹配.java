/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] reg = p.toCharArray();

        int m = str.length, n = reg.length;
        boolean[][] result = new boolean[m + 1][n + 1];
        result[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (reg[j - 1] == '*') {
                    result[i][j] = result[i][j - 1];
                    if (i > 0) {
                        result[i][j] = result[i][j] || result[i - 1][j];
                    }
                } else if (i > 0 && (reg[j - 1] == '?' || str[i - 1] == reg[j - 1])) {
                    result[i][j] = result[i - 1][j - 1];
                }
            }
        }

        return result[m][n];
    }

}
// @lc code=end
