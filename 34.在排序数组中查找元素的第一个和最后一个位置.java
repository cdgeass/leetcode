/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);
        return new int[] {start, end};
    }

    public int binarySearch(int[] nums, int target, boolean start) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == target) {
                result = mid;

                if (start) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
// @lc code=end

