import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Debug {

    public static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();

            Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();

                Map<Character, Integer> charCount = new HashMap<>();
                for (char c : chars) {
                    int count = charCount.getOrDefault(c, 0);
                    charCount.put(c, count + 1);
                }

                List<String> list = map.get(charCount);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(str);
                map.put(charCount, list);
            }

            for (List<String> list : map.values()) {
                result.add(list);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
