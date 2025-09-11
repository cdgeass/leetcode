/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i >= 0) {
            int j = nums.length - 1;
            for (; j > i; j--) {
                if (nums[i] < nums[j]) {
                    break;
                }
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            
            left++;
            right--;
        }
    }
}
// @lc code=end
