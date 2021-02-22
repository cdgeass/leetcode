/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {

    private static final int[] NUMS = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int count;
        for (int i = 0; i < NUMS.length; i++) {
            count = num / NUMS[i];
            if (count > 0) {
                for (int j = 0; j < count; j++) {
                    sb.append(intMap(NUMS[i]));
                }
                num = num - (count * NUMS[i]);
            }
        }

        return sb.toString();
    }

    public static String intMap(int num) {
        switch (num) {
            case 1000: return "M";
            case 900: return "CM";
            case 500: return "D";
            case 400: return "CD";
            case 100: return "C";
            case 90: return "XC";
            case 50: return "L";
            case 40: return "XL";
            case 10: return "X";
            case 9: return "IX";
            case 5: return "V";
            case 4: return "IV";
            case 1: return "I";
            default: return "";
        }
    }
}
// @lc code=end

