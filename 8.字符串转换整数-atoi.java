/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();

        int negative = 1;
        int negativeTime = 0;
        int plusTime = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 32)  {
                if (result != 0 || negativeTime > 0 || plusTime > 0) {
                    return result * negative;
                } else {
                    continue;
                }
            }           
            if (c == 45 || c == 43) {
                if (negativeTime > 0 || plusTime > 0) {
                    return result * negative;
                }
                if (c == 45) {
                    negative = -1;
                } else {
                    negative = 1;
                }
                negativeTime++;
            } else if (c >= 48 && c <= 57) {
                if (result > Integer.MAX_VALUE / 10) {
                    if (negative == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                if (result == Integer.MAX_VALUE / 10) {
                    if (negative == 1 && (c - 48) > 7) {
                        return Integer.MAX_VALUE;
                    } else if (negative == -1 && (c - 48) > 8) {
                        return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + (c - 48);
                plusTime++;
            } else {
                return result * negative;
            }
        }

        return result * negative;
    }
}
// @lc code=end

