/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int v = nums[i] + nums[j] + nums[k];
                if (v == target) {
                    return target;
                } else if (v > target) {
                    k--;
                } else {
                    j++;
                }

                if (Math.abs(v - target) < Math.abs(result - target)) {
                    result = v;
                }
            }
        }

        return result;
    }
}
// @lc code=end

