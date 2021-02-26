import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);
        
        int diff = target - (nums[0] + nums[1] + nums[2]);
        for (int i = 0; i < length; i++) {
            int left = i + 1, right = length - 1;

            while (left < right) {
                int tempDiff = target - (nums[i] + nums[left] + nums[right]);
                
                if (Math.abs(tempDiff) < Math.abs(diff)) {
                    diff = tempDiff;
                    if (diff == 0) {
                        return target;
                    }
                }

                if (tempDiff < 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return target - diff;
    }
}
// @lc code=end

