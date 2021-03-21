package com.java.codinginterview;

import java.util.Arrays;

/**
 * @author xing
 * @create 2021-03-21 10:13
 */
public class PathInArray12 {

    public boolean exist(char[][] board, String word) {
        //思考:暴力穷举所有路径
        // 1.矩阵中是否有重复字符？
        // 2. 何时触发退出条件
//        记录格子是否被进入，初始化为false
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col]; // 默认为false
        return backtrack(board, word, flag);
    }

    public boolean backtrack(char[][] board, String word, boolean[][] flag) {
        char[] words = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (hasPath(row, col, flag, board, words, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPath(int row, int col, boolean[][] flag, char[][] board, char[] words, int k) {
        // 终止条件
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != words[k] || flag[row][col])
            return false;
        if (k == words.length - 1) return true; // 匹配到words的最后一个字符，返回true

        // 做选择
        flag[row][col] = true;

        // 前进进行决策
        // 判断当前位置上方有元素且没有被访问过
        if (hasPath(row - 1, col, flag, board, words, k + 1))
            return true;
        // 判断当前位置下方有元素且没有被访问过
        if (hasPath(row + 1, col, flag, board, words, k + 1))
            return true;
        // 判断当前位置左方有元素且没有被访问过
        if (hasPath(row, col - 1, flag, board, words, k + 1))
            return true;
        // 判断当前位置右方有元素且没有被访问过
        if (hasPath(row, col + 1, flag, board, words, k + 1))
            return true;

        // 撤销上次的选择
        flag[row][col] = false;
        return false;

    }

    public boolean hasPath1(int row, int col, boolean[][] flag, char[][] board, char[] words, int k) {
        // 终止条件
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != words[k])
            return false;
        if (k == words.length - 1) return true; // 匹配到words的最后一个字符，返回true

        // 做选择
        board[row][col] = '\0';  // 利用对board[row][col]处值的修改来标记是否访问过，不需要使用功能flag数组进行标志
        // 前进进行决策
        boolean res = hasPath(row - 1, col, flag, board, words, k + 1) || hasPath(row + 1, col, flag, board, words, k + 1) ||
        hasPath(row, col - 1, flag, board, words, k + 1) || hasPath(row, col + 1, flag, board, words, k + 1);
        // 撤销选择
        board[row][col] = words[k];
        return res;
    }

    public static void main(String[] args) {
        boolean[][] flag = new boolean[3][4];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++) {
                System.out.println(flag[i][j]);
            }
        System.out.println(Arrays.deepToString(flag));
    }
}
