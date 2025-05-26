/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        char[] chars = s.toCharArray();

        int len = chars.length;
        char[] result = new char[len];
        int index = 0;

        for (int i = 0; i < numRows; i++) {
            int d1, d2;
            if (i == 0 || i == numRows - 1) {
                d1 = (numRows - 2) * 2 + 2;
                d2 = d1;
            } else {
                d1 = (numRows - i - 2) * 2 + 2;
                d2 = (i - 1) * 2 + 2;
            }

            int d = d2;
            for (int j = i; j < len; j += d) {
                result[index++] = chars[j];
                d = d == d1 ? d2 : d1;
            }
        }
        return new String(result);
    }
}
// @lc code=end
