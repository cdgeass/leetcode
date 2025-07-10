/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;

        int i = 0, j = len - 1;
        
        int area = 0;
        while (i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return area;
    }
}
// @lc code=end
