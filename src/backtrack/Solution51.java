package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 *
 * 51. N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 思路：
 * 1. 遍历每一行，在每一行中选取一个有效位置
 * 2. 在同一行或同一列或同一斜线上的棋子w为无效位置
 *
 * 递归结束条件：递归到第 n行，表示 N个皇后都放置完毕，也就找到一个可能的解。将数组转换成表示棋盘状态的列表，并将该列表加入答案。
 * 递归过程：从第0行开始， 从前一行递归到后一行。
 * @create 2025-03-05 22:57
 **/
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        backtrack(n, 0, chess, ans);
        return ans;
    }

    // 每一行中选取一个有效位置
    // 在同一行或同一列或同一斜线上的棋子w为无效位置
    public void backtrack(int n, int row, char[][] chess, List<List<String>> ans){
        //如果一直找到第n行，表明此时已经在0到n-1行内找到了符合条件的摆放位置，则记录结果回溯到上一层，继续寻找
        if(row == n){
            List<String> tmpList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                tmpList.add(String.valueOf(chess[i]));
            }
            ans.add(tmpList);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(!isValidPos(n, col, row, chess)){
                continue;
            }
            // 放置皇后
            chess[row][col] = 'Q';
            // 继续下一行检查
            backtrack(n, row + 1, chess, ans);
            // 移除当前位置的皇后
            chess[row][col] = '.';
        }
    }

    // 判断当前位置是否有效
    // 在同一行或同一列或同一斜线上的棋子w为无效位置
    public boolean isValidPos(int n, int col, int row, char[][] chess){
        // 同一列有Queen
        for(int i = 0; i < n; i++){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        // 同一行有Queen
        for(int i = 0; i < n; i++){
            if(chess[row][i] == 'Q'){
                return false;
            }
        }
        // 同一斜线上有Queen，此时只要检查左上方和右上方即可，因为后面的位置在后面穷举的过程中会继续检查
        // 检查右上方
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        // 检查左上方
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
