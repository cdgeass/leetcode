/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtracking(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] cadidates, int index, int target, List<Integer> list) {
        if (index >= cadidates.length) {
            return;
        }

        for (int i = index; i < cadidates.length; i++) {
            if (i > index && cadidates[i] == cadidates[i - 1]) {
                continue;
            }

            int v = cadidates[i];

            if (v == target) {
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(v);
                result.add(tempList);
            } else if (v < target) {
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(v);
                backtracking(cadidates, i + 1, target - v, tempList);
            } 
        }
    }
}
// @lc code=end

