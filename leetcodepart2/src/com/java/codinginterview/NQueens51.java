package com.java.codinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * @author xing
 * @create 2021-03-20 22:06
 */
public class NQueens51 {
    List<List<String>> ans = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        // 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
        //初始化棋盘为.
        char[] queen = new char[4];
        Arrays.fill(queen, '.');
        char[][] qipan = new char[4][4];
        for (int i = 0; i < 4; i++) {
            qipan[i] = queen;
        }
        backtrack(qipan, 0, n);
        return ans;
    }

    public void backtrack(char[][] qipan, int row, int n) {
        // 触发结束条件
        // 如果已经放置到最后一行
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < qipan.length; i++) {
                temp.add(new String(qipan[i]));
            }
            ans.add(new ArrayList(temp));
            return;
        }

        for (int col = 0; col < n; col++) {
            //排除不合法的选择
            if (!isVaild(qipan, row, col)) {
                continue;
            }
            // 做选择
            qipan[row][col] = 'Q';
            // 进入下一行进行决策
            backtrack(qipan, row + 1, n);
            // 移除上一次做的选择
            qipan[row][col] = '.';
        }
    }

    public boolean isVaild(char[][] qipan, int row, int col) {
        int n = qipan.length;
        //检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (qipan[i][col] == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (qipan[i][j] == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (qipan[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] queen = new char[4];
        Arrays.fill(queen, '.');
        char[][] qipan = new char[4][4];
        for (int i = 0; i < 4; i++) {
            qipan[i] = queen;
        }
        System.out.println(Arrays.toString(queen));
        NQueens51 nq = new NQueens51();
        System.out.println(nq.solveNQueens(4));
    }
}
