/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = i;
                result[1] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
// @lc code=end

