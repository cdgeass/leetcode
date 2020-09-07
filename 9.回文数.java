/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int palindrome = 0;
        while (x > palindrome) {
            palindrome = palindrome * 10 + x % 10;
            x /= 10;
        }

        if (palindrome != x && palindrome / 10 != x) {
            return false;
        }

        return true;
    }
}
// @lc code=end

