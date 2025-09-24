/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }

        backtracking(list, 0);

        return result;
    }

    public void backtracking(List<Integer> nums, int index) {
        if (index == nums.size()) {
            result.add(new ArrayList<>(nums));
        }

        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            backtracking(nums, index + 1);
            Collections.swap(nums, index, i);
        }
    }
}
// @lc code=end

