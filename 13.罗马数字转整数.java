/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        char[] str = s.toCharArray();

        int result = 0;

        int len = str.length;
        for (int i = len - 1; i >= 0; i--) {
            int v = 0;
            switch (str[i]) {
                case 'I':
                    v = 1;
                    break;
                case 'V':
                    if (i - 1 >= 0 && (str[i - 1] == 'I')) {
                        i--;
                        v = 4;
                    } else {
                        v = 5;
                    }
                    break;
                case 'X':
                    if (i - 1 >= 0 && str[i - 1] == 'I') {
                        i--;
                        v = 9;
                    } else {
                        v = 10;
                    }
                    break;
                case 'L':
                    if (i - 1 >= 0 && str[i - 1] == 'X') {
                        i--;
                        v = 40;
                    } else {
                        v = 50;
                    }
                    break;
                case 'C':
                    if (i - 1 >= 0 && str[i - 1] == 'X') {
                        i--;
                        v = 90;
                    } else {
                        v = 100;
                    }
                    break;
                case 'D':
                    if (i - 1 >= 0 && str[i - 1] == 'C') {
                        i--;
                        v = 400;
                    } else {
                        v = 500;
                    }
                    break;
                case 'M':
                    if (i - 1 >= 0 && str[i - 1] == 'C') {
                        i--;
                        v = 900;
                    } else {
                        v = 1000;
                    }
                    break;
            }

            result += v;
        }

        return result;
    }
}
// @lc code=end

