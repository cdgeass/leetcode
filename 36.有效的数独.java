/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] box = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];

                if (c != '.') {
                    int v = c - '1';

                    row[i][v] += 1;
                    col[j][v] += 1;
                    box[i / 3][j / 3][v] += 1;

                    if (row[i][v] > 1 || col[j][v] > 1 || box[i / 3][j / 3][v] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end

