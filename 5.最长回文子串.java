import java.util.function.BiConsumer;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        
        int[] result = new int[] {0, 1};
        for (int i = 0; i < length - 1; i++) {
            BiConsumer<Integer, Integer> check = (leftCursor, rightCursor) -> {
                char left, right;
                for (int j = 0; leftCursor - j >= 0 && rightCursor + j < length; j++) {
                    left = chars[leftCursor - j];
                    right = chars[rightCursor + j];

                    if (left == right) {
                        int temp = rightCursor - leftCursor + 2 * j + 1;
                        if (temp > result[1]) {
                            result[1] = temp;
                            result[0] = leftCursor - j;
                        }
                    } else {
                        break;
                    }
                }
            };

            check.accept(i, i);
            if (chars[i] == chars[i + 1]) {
                check.accept(i, i + 1);
            }
        }

        return s.substring(result[0], result[0] + result[1]);
    }

}
// @lc code=end

