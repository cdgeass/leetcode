import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int curr = 0; curr < nums.length ; curr++) {
            if (nums[curr] > 0) {
                return results;
            }
            if (curr > 0 && nums[curr] == nums[curr - 1]) {
                continue;
            }

            int left = curr + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[curr] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[curr]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);

                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            
        }
        return results;
    }

}
// @lc code=end

