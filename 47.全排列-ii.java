/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        boolean[] vis = new boolean[nums.length];
        backtracking(nums, 0, vis, new ArrayList<>());

        return result;
    }

    public void backtracking(int[] nums, int index, boolean[] vis, List<Integer> perm) {
        if (index == nums.length) {
            result.add(new ArrayList<>(perm));
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtracking(nums, index + 1, vis, perm);
            vis[i] = false;
            perm.remove(index);
        }
    }
}
// @lc code=end
