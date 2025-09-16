/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[][] row = new int[9][9];
    private int[][] col = new int[9][9];
    private int[][][] box = new int[3][3][9];
    private List<int[]> indexList = new ArrayList<>();
    private boolean checked = false;

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int[] index = new int[] { i, j };
                    indexList.add(index);
                } else {
                    int v = board[i][j] - '1';
                    row[i][v] += 1;
                    col[j][v] += 1;
                    box[i / 3][j / 3][v] += 1;
                }
            }
        }

        backtracking(board, indexList, 0);
    }

    private void backtracking(char[][] board, List<int[]> indexList, int n) {
        if (n == indexList.size()) {
            checked = true;
            return;
        }

        int[] index = indexList.get(n);
        int i = index[0], j = index[1];
        for (int v = 0; v < 9; v++) {
            if (row[i][v] == 0 && col[j][v] == 0 && box[i / 3][j / 3][v] == 0) {
                row[i][v] = col[j][v] = box[i / 3][j / 3][v] = 1;
                board[i][j] = (char) ('1' + v);
                backtracking(board, indexList, n + 1);
                if (checked) {
                    break;
                }

                row[i][v] = col[j][v] = box[i / 3][j / 3][v] = 0;
            }
        }
    }
}
// @lc code=end
