/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length(), m = words.length, n = words[0].length();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i + m * n > len) {
                break;
            }

            Map<String, Integer> wordCount = new HashMap<>();

            for (int j = 0; j < m; j++) {
                String subWord = s.substring(i + j * n, i + (j + 1) * n);
                wordCount.put(subWord, wordCount.getOrDefault(subWord, 0) + 1);
            }

            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) - 1);
                if (wordCount.get(word) == 0) {
                    wordCount.remove(word);
                }
            }

            if (wordCount.isEmpty()) {
                result.add(i);
            }

            for (int k = i + n; k <= len - (m * n); k += n) {
                String subWord = s.substring(k + (m - 1) * n, k + m * n);
                wordCount.put(subWord, wordCount.getOrDefault(subWord, 0) + 1);
                if (wordCount.get(subWord) == 0) {
                    wordCount.remove(subWord);
                }

                subWord = s.substring(k - n, k);
                wordCount.put(subWord, wordCount.getOrDefault(subWord, 0) - 1);
                if (wordCount.get(subWord) == 0) {
                    wordCount.remove(subWord);
                }

                if (wordCount.isEmpty()) {
                    result.add(k);
                }
            }
        }

        return result;
    }
}
// @lc code=end

