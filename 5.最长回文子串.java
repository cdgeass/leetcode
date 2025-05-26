/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < len - 1; i++) {
            int j;
            if (chars[i] == chars[i + 1]) {
                j = i + 1;
                int k = 0;
                while (true) {
                    k++;
                    if (i - k < 0 || j + k >= len) {
                        k--;
                        break;
                    }
                    if (chars[i - k] != chars[j + k]) {
                        k--;
                        break;
                    }
                }

                if (((j + k) - (i - k)) > endIndex - startIndex) {
                    startIndex = i - k;
                    endIndex = j + k;
                }
            }

            if (i > 0 && chars[i - 1] == chars[i + 1]) {
                j = i;

                int k = 0;
                while (true) {
                    k++;
                    if (i - k < 0 || j + k >= len) {
                        k--;
                        break;
                    }
                    if (chars[i - k] != chars[j + k]) {
                        k--;
                        break;
                    }
                }

                if (((j + k) - (i - k)) > endIndex - startIndex) {
                    startIndex = i - k;
                    endIndex = j + k;
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }
}
// @lc code=end

