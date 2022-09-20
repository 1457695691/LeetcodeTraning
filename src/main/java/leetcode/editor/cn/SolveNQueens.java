package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 51. N 皇后
 * @date 2022/9/20 16:34
 */
public class SolveNQueens {
    /**
     * 思路： todo@Ayuan 回溯树
     */
    class Solution {
        //路径
        private List<String> list = new ArrayList<>();
        //结果
        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            //初始化变量
            char[][] board = new char[n][n];
            //初始化棋盘
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], '.');
            }
            //从0行开始回溯搜索
            backtrack(board, 0);
            return result;
        }

        private void backtrack(char[][] board, int row) {
            // 满足要求
            if (list.size() == board.length) {
                result.add(list);
                return;
            }
            for (int i = 0; i < board.length; i++) {
                // 该格不符合放棋子的条件
                if (!isValid(board, row, i)) {
                    continue;
                }
                // 放棋子
                board[row][i] = 'Q';
                // 记录当前行的数据
                list.add(new String(board[row]));
                // 处理下一行
                backtrack(board, row + 1);
                // 移除棋子
                board[row][i] = '.';
                // 去除当前行的数据
                list.remove(list.size() - 1);
            }
        }

        //当前放置位置是否合法
        private boolean isValid(char[][] board, int row, int col) {
            int n = board.length;
            //1.检查列是否冲突
            for (int i = 0; i < n; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            //2.检查右上是否冲突
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            //3.检查左下是否冲突
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

    }
}
