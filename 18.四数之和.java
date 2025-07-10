/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;
        for (int i = 0; i <= len - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }

            for (int j = i + 1; j <= len - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }

                int t = target - (nums[i] + nums[j]);
                int m = j + 1, n = len - 1;
                while (m < n) {
                    int temp = nums[m] + nums[n];
                    if (temp < t) {
                        m++;
                    } else if (temp > t) {
                        n--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));

                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        m++;

                        while (m < n && nums[n] == nums[n - 1]) {
                            n--;
                        }
                        n--;
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end

