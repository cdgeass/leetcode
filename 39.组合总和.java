/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] cadidates, int index, int target, List<Integer> list) {
        if (index >= cadidates.length) {
            return;
        }

        for (int i = index; i < cadidates.length; i++) {

            int v = cadidates[i];

            if (v == target) {
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(v);
                result.add(tempList);
            } else if (v < target) {
                int temp = target;
                List<Integer> tempList = new ArrayList<>(list);

                while (v <= temp) {
                    tempList.add(v);

                    temp -= v;
                    if (temp < 0) {
                        break;
                    } else if (temp == 0) {
                        result.add(tempList);
                    } else {
                        List<Integer> subList = new ArrayList<>(tempList);
                        backtracking(cadidates, i + 1, temp, subList);
                    }
                }
            } 
        }
    }
}
// @lc code=end
