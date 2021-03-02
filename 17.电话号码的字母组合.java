import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList();
        for (String str : map[digits.charAt(0) - '2']) {
            result.add(str);
        }
        for (int i = 1; i < length; i++) {
            result = multi(result, map[digits.charAt(i) - '2']);
        }
        return result;
    }

    String[][] map = {{"a","b","c"},
    {"d","e","f"},
    {"g","h","i"},
    {"j","k","l"},
    {"m","n","o"},
    {"p","q","r","s"},
    {"t","u","v"},
    {"w","x","y","z"}};

    public List<String> multi(List<String> list1, String[] c2) {
        List<String> result = new ArrayList(list1.size() + c2.length);
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < c2.length; j++) {
                result.add(list1.get(i) + c2[j]);
            }
        }
        return result;
    }
}
// @lc code=end

