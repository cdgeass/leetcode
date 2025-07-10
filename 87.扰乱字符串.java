/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 1 && s1.equals(s2)) {
            return true;
        }

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int len = str1.length;
        int[][][] temp = new int[len][len][len];

        return isScramble(str1, 0, len - 1, str2, 0, len - 1, temp);
    }

    private boolean isScramble(char[] s1, int i, int j, char[] s2, int m, int n, int[][][] temp) {
        if (temp[i][m][j - i] != 0) {
            return temp[i][m][j - i] == 1;
        }

        boolean equals = true;
        for (int k = 0; k <= j - i; k++) {
            if (s1[i + k] != s2[m + k]) {
                equals = false;
                break;
            }
        }
        if (equals) {
            temp[i][m][j - i] = 1;
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int k = i; k <= j; k++) {
            int count = map.getOrDefault(s1[k], 0) + 1;
            map.put(s1[k], count);
        }
        for (int k = m; k <= n; k++) {
            int count = map.getOrDefault(s2[k], 0) - 1;
            map.put(s2[k], count);
        }
        for (int count : map.values()) {
            if (count != 0) {
                temp[i][m][j - i] = -1;
                return false;
            }
        }

        for (int k = 0; k < j - i; k++) {
            if (isScramble(s1, i, i + k, s2, m, m + k, temp)
                    && isScramble(s1, i + k + 1, j, s2, m + k + 1, n, temp)) {
                temp[i][m][k] = 1;
                return true;
            }
            if (isScramble(s1, i, i + k, s2, n - k, n, temp)
                    && isScramble(s1, i + k + 1, j, s2, m, n - k - 1, temp)) {
                temp[i][n - k][k] = 1;
                return true;
            }
        }

        temp[i][m][j - i] = -1;
        return false;
    }
}
// @lc code=end
