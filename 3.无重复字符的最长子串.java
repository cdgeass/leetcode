/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        char[] charArr = s.toCharArray();
        int max = 1;
        int left = 0, right = 1;
        for (right = 1; right < length; right++) {
            char c = charArr[right];
            max = Math.max(max, right - left);
            for (int j = left; j < right; j++) {
                if (c == charArr[j]) {
                    j = left++;
                }
            }
        }

        return Math.max(max, right - left);
    }

}
// @lc code=end

