/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if (length == 1) return false;
    
        char[] stack = new char[length];
        int j = 0;
        stack[j] = s.charAt(j);
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);

            if (c == ')' || c == '}' || c == ']') {
                if (j < 0 || (c - 1 != stack[j] && c - 2 != stack[j])) {
                    return false;
                } else {
                    j--;
                    if (j < -1) {
                        return false;
                    }
                }
            } else {
                stack[++j] = c;
            }
        }
        return j == -1;
    }
}
// @lc code=end

