/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int m = num / 1000;
        for (int i = 0; i < m; i++) {
            sb.append("M");
        }
        num %= 1000;

        int c = num / 100;
        sb.append(buildSubString(c, "M", "D", "C"));
        num %= 100;

        int x = num / 10;
        sb.append(buildSubString(x, "C", "L",  "X"));
        num %= 10;

        sb.append(buildSubString(num, "X", "V", "I"));

        return sb.toString();
    }

    private String buildSubString(int n, String s1, String s2, String s3) {
        StringBuilder sb = new StringBuilder();
        if (n == 9) {
            sb.append(s3 + s1);
        } else if (n == 4) {
            sb.append(s3 + s2);
        } else if (n >= 5) {
            sb.append(s2);
            for (int i = 5; i < n; i++) {
                sb.append(s3);
            }
        } else {
            for (int i = 0; i < n; i++) {
                sb.append(s3);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

