/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {

    public int romanToInt(String s) {
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num += charMap(s.charAt(i));
            if (i != 0) {
                if (charMap(s.charAt(i)) > charMap(s.charAt(i - 1))) {
                    num -= charMap(s.charAt(--i));
                }
            }
        }
        return num;
    }

    public static int charMap(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
// @lc code=end

