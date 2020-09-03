/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result * 10 == Integer.MAX_VALUE && temp > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result * 10 == Integer.MIN_VALUE && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
        }
        return result;
    }
}
// @lc code=end

