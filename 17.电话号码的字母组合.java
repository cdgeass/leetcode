/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static Map<Character, List<String>> C_MAP = new HashMap<>();

    static {
        C_MAP.put('2', Arrays.asList("a", "b", "c"));
        C_MAP.put('3', Arrays.asList("d", "e", "f"));
        C_MAP.put('4', Arrays.asList("g", "h", "i"));
        C_MAP.put('5', Arrays.asList("j", "k", "l"));
        C_MAP.put('6', Arrays.asList("m", "n", "o"));
        C_MAP.put('7', Arrays.asList("p", "q", "r", "s"));
        C_MAP.put('8', Arrays.asList("t", "u", "v"));
        C_MAP.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        if (digits.length() == 1) {
            return C_MAP.get(digits.charAt(0));
        }

        List<String> result = new ArrayList<>();
        char[] numbers = digits.toCharArray();

        backtrack(numbers, 0, "", result);

        return result;
    }

    private void backtrack(char[] numbers, int i, String prefix, List<String> result) {
        List<String> strs = C_MAP.get(numbers[i]);

        for (String s : strs) {
            if (i == numbers.length - 1) {
                result.add(prefix + s);
            } else {
                backtrack(numbers, i + 1, prefix + s, result);
            }
        }
    }

}
// @lc code=end
