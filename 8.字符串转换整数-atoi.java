/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;

        int i = 0;
        for (; i < len; i++) {
            if (chars[i] != ' ') {
                break;
            }
        }

        int sign = 1;
        if (i < len && (chars[i] == '+' || chars[i] == '-')) {
            sign = chars[i++] == '+' ? 1 : -1;
        }

        int result = 0;
        for (; i < len; i++) {
            char c = chars[i];
            if (result == 0 && c == '0') {
                continue;
            }
            if (c < '0' || c > '9') {
                break;
            }

            int t = c - '0';
            if (result > (Integer.MAX_VALUE - t) / 10) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + t;
        }

        return result * sign;
    }
}
// @lc code=end
