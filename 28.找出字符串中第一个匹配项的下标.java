/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();

        int l1 = str1.length;
        int l2 = str2.length;

        int i = 0, j = i + l2 - 1;
        while (j < l1) {
            if (str1[i] == str2[0] && str1[j] == str2[l2 - 1]) {
                if (l2 <= 2) {
                    return i;
                }
                for (int m = 1; m < l2 - 1; m++) {
                    if (str1[i + m] != str2[m]) {
                        break;
                    }
                    if (m == l2 - 2) {
                        return i;
                    }
                }
            }         
            i++;
            j++;
        }
        return -1;
    }
}
// @lc code=end

