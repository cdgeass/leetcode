/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String preStr = countAndSay(n - 1);
        char[] chars = preStr.toCharArray();

        StringBuilder result = new StringBuilder();

        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                result.append(count).append(chars[i - 1]);
                count = 1;
            }
        }

        result.append(count).append(chars[chars.length - 1]);

        return result.toString();
    }
}
// @lc code=end
