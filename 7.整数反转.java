/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }

        int result = 0;
        while (true) {
            result += x % 10;

            x /= 10;
            if (x == 0) {
                break;
            }

            if ((result > 0 && result > Integer.MAX_VALUE / 10)
                    || (result < 0 && result < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            result *= 10;
        }
        return result;
    }
}
// @lc code=end
