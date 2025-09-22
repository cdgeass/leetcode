/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[max]) {
                max = i;
            }
        }

        int result = 0;

        int h = 0;
        for (int i = 0; i < max; i++) {
            if (height[i] > h) {
                h = height[i];
            }
            result += h - height[i];
        }

        h = 0;
        for (int i = height.length - 1; i > max; i--) {
            if (height[i] > h) {
                h = height[i];
            }
            result += h - height[i];
        }

        return result;
    }
}
// @lc code=end
