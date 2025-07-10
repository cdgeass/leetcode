/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            i++;
            nums[i - 1] = nums[j];
        }

        return i;
    }
}
// @lc code=end

