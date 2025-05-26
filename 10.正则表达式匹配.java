/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if (p == ".*") {
            return true;
        }

        char[] str = s.toCharArray();
        char[] reg = p.toCharArray();

        int m = str.length, n = reg.length;
        boolean[][] result = new boolean[m + 1][n + 1];
        result[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (reg[j - 1] == '*') {
                    result[i][j] = result[i][j - 2];
                    if (isMatch(str, i, reg, j - 1)) {
                        result[i][j] = result[i][j] || result[i-1][j];
                    }
                } else {
                    if (isMatch(str, i, reg, j)) {
                        result[i][j] = result[i - 1][j - 1];
                    }
                }
            }
        }

        return result[m][n];
    }

    private boolean isMatch(char[] str, int i, char[] reg, int j) {
        if (i == 0) {
            return false;
        }
        if (reg[j - 1] == '.') {
            return true;
        }
        return str[i - 1] == reg[j - 1];
    }
}
// @lc code=end

