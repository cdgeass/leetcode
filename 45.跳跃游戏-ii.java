/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int result = 0;

        int i = 0;
        int j = 0;
        for (int k = 0; k < nums.length - 1; k++) {
            j = Math.max(nums[k] + k, j);
            if (k == i) {
                i = j;
                result++;
            }
        }

        return result;
    }
}
// @lc code=end
