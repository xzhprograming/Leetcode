package com.java.hot100;

/**
 *79. 单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 思路：
 * 设函数check(i, j, k)表示从网格的（i， j）位置出发，判断是否能搜索到单词word[k...],其中word[k...]表示字符串word从k个字符开始的后缀字符串，
 * 如果能搜索到，则返回 true，反之返回 false
 * check(i, j, k)执行步骤：
 * 如果board[i][j] != s[k], return false；
 * 如果当前已经访问到字符串的末尾，且对应字符依然匹配，此时直接返回true。
 * 否则，遍历当前位置的相邻位置，若从某个相邻位置出发，能够搜索到子串word[k+1...],则返回true，否则返回false
 * 对每一个位置都调用check(i,j,0)进行检查
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
