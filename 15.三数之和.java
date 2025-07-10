/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int iv = nums[i];

            int k = len - 1;
            int j = i + 1;

            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (nums[j] + nums[k] + iv == 0) {
                    result.add(Arrays.asList(iv, nums[j], nums[k]));

                    j++;
                    k--;
                } else if (nums[j] + nums[k] > -iv) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
// @lc code=end
