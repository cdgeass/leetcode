/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int i_value = height[i];
            int j_value = height[j];

            int h = 0, w = j - i;
            if (i_value <= j_value) {
                h = i_value;
                i++;
            } else {
                h = j_value;
                j--;
            }

            max = Math.max(max, h * w);
        }
        return max;
    }
}
// @lc code=end

