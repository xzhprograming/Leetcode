package com.java.hot100;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 每次只能向下或者向右移动一步。
 *
 * 解题思路：
 * 动态规划
 * 1. 定义dp数组的含义
 * int[][] dp = new int[row][col]; // 起点格子到此格子的最短路径
 *
 *2. 定义 base case
 * 当为起点时，即dp[0][0] = grid[0][0];
 *
 * 3. 明确状态转移方程
 * 四种情况
 *
 * @author xing
 * @create 2021-05-02 22:12
 */
public class MinPathSum64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;

        // 定义dp数组,含义：起点格子到此格子的最短路径
        int[][] dp = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                // 四种情况
                // 1. 可能从左边或上边过来
                if(i != 0 && j != 0){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    continue;
                }
                // 2. 只能从左边过来
                if(i == 0 && j != 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                // 3. 只能从上边过来
                if(i != 0 && j == 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                // 4. 当为起点时,base case
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
