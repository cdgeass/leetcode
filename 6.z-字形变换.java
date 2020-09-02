import java.util.Map;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 2) {
            return s;
        }

        Map<Integer, StringBuilder> resultMap = new HashMap<>();
        for (int i = 1; i <= numRows; i++) {
            resultMap.put(i, new StringBuilder());
        }
    
        char[] chars = s.toCharArray();
        int length = s.length();
    
        int offset = 1, cursor = 0;
        for (int i = 0; i < length; i++) {
            StringBuilder sb = resultMap.get(cursor += offset);
            sb.append(chars[i]);
            if (i != 0 && (cursor % numRows == 0 || cursor % numRows == 1)) {
                offset = -offset;
            }
        }
    
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            sb.append(resultMap.get(i));
        }
    
        return sb.toString();
    }
}
// @lc code=end

