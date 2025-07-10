/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, n, n, "");
        return result;
    }

    private void backtrack(List<String> result, int left, int right, String str) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        if (left > 0) {
            backtrack(result, left - 1, right, str + "(");
        }
        if (right > left) {
            backtrack(result, left, right - 1, str + ")");
        }
    }
}
// @lc code=end

