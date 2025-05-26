/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return 0;
        }

        char[] str = s.toCharArray();
        int[] lens = new int[len];

        int result = 0;
        for (int i = 1; i < len; i++) {
            if (str[i] == ')') {
                if (str[i - 1] == '(') {
                    if (i > 2) {
                        lens[i] = lens[i - 2] + 2;
                    } else {
                        lens[i] = 2;
                    }
                } else {
                    // (()())
                    int l = lens[i - 1];
                    if (i - l > 0 && str[i - l - 1] == '(') {
                        if (i - l - 2 > 0) {
                            lens[i] = l + lens[i - l - 2] + 2;
                        } else {
                            lens[i] = l + 2;
                        }
                    }
                }
                result = Math.max(result, lens[i]);
            }
        }
        return result;
    }
}
// @lc code=end
