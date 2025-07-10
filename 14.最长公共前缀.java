/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }
            if (i == 0) {
                len = strs[i].length();
            } else {
                len = Math.min(len, strs[i].length());
            }
        }

        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, len);
    }
}
// @lc code=end

