/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                char c = stack.peek();
                if (c + 1 == chars[i] || c + 2 == chars[i]) {
                    stack.poll();
                } else {
                    stack.push(chars[i]);
                }
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

