/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return Collections.singletonList(Collections.singletonList(strs[0]));
        }

        Map<Map<Character, Integer>, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();

            Map<Character, Integer> charCount = new HashMap<>(chars.length);
            for (char c : chars) {
                int count = charCount.getOrDefault(c, 0);
                charCount.put(c, count + 1);
            }

            List<String> list = result.get(charCount);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            result.put(charCount, list);
        }

        return new ArrayList<>(result.values());
    }
}
// @lc code=end
