/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend > 0) {
            return -divide(-dividend, divisor);
        }
        if (divisor > 0) {
            return -divide(dividend, -divisor);
        }

        if (dividend > divisor) {
            return 0;
        }

        int result = 1, d = divisor;
        while ((dividend - divisor) <= divisor) {
            result += result;
            divisor += divisor;
        }

        return result + divide(dividend - divisor, d);
    }
}
// @lc code=end

