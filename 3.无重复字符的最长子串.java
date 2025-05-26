/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();

        int result = 1;
        int i = 0;
        for (int j = 0; j < len; j++) {
            for (int k = i; k < j; k++) {
                if (chars[j] == chars[k]) {
                    i = k + 1;
                    break;
                }
            }
            
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}
// @lc code=end

