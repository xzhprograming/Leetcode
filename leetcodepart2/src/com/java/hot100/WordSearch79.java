package com.java.hot100;

/**
 *79. 单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 链接：https://leetcode-cn.com/problems/word-search
 * @author xing
 * @create 2021-05-11 21:23
 */
public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                boolean flag = backtrack(board, visited, i, j, 0, word);
                if(flag)
                    return true;
            }
        }
        return false;
    }


    public boolean backtrack(char[][] board, boolean[][] visited, int i, int j, int k, String word){

        if(board[i][j] != word.charAt(k)){
            return false;
        } else if(k == word.length() - 1){
            return true;
        }

        visited[i][j] = true;
        // 定义偏移数组
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for(int[] dir : directions){
            // 计算下一次的位置
            int newi = i + dir[0];
            int newj = j + dir[1];
            // 边界条件
            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                // 若未被访问过
                if(!visited[newi][newj]){
                    boolean flag = backtrack(board, visited, newi, newj, k + 1, word);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
