import java.util.function.BiFunction;

/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();

        BiFunction<Integer, Integer, Boolean> isMatch = (i, j) -> {
            if (i == -1) {
                return false;
            }
            if (ps[j] == '.') {
                return true;
            }
            return ss[i] == ps[j];
        };

        boolean[][] result = new boolean[ss.length + 1][ps.length + 1];
        result[0][0] = true;
        for (int i = 0; i <= ss.length; i++) {
            for (int j = 1; j <= ps.length; j++) {
                if (ps[j - 1] == '*') {
                        result[i][j] = result[i][j - 2];
                    if (isMatch.apply(i - 1, j - 2)) {
                        result[i][j] = result[i][j] || result[i - 1][j];
                    }
                } else {
                    if (isMatch.apply(i - 1, j - 1)) {
                        result[i][j] = result[i - 1][j - 1];
                    }
                }
            }
        }

        return result[ss.length][ps.length];
    }
}
// @lc code=end

