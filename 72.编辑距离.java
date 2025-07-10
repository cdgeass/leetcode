/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }

        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return len1 + len2;
        }

        int[][] result = new int[len1 + 1][len2 + 1];
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        for (int i = 0; i <= len1; i++) {
            result[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            result[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int d = result[i - 1][j] + 1;
                int a = result[i][j - 1] + 1;
                int c = result[i - 1][j - 1];
                if (str1[i - 1] != str2[j - 1]) {
                    c += 1;
                }
                result[i][j] = Math.min(d, Math.min(a, c));
            }
        }

        return result[len1][len2];
    }
}
// @lc code=end

