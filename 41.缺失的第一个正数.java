/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] != 1) {
                return 1;
            } else {
                return 2;
            }
        }

        Arrays.sort(nums);

        int result = -1;
        int i = 1;
        int j = -1;
        for (; i < nums.length; i++) {
            if (j == -1 && nums[i] > 0) {
                j = i - 1;
            }
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 1 && nums[i] - 1 != nums[i - 1]) {
                result = nums[i - 1] + 1;
                break;
            }
        }
        if (i == nums.length) {
            result = nums[nums.length - 1] + 1;
        }
        if (j >= 0 && nums[j] > 1) {
            result = 1;
        }

        return Math.max(result, 1);
    }
}
// @lc code=end
