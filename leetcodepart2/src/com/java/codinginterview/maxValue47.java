package com.java.codinginterview;

import java.util.Scanner;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 解题思路：
 * 有两种情况可以走到（i，j）
 * 1）（i - 1, j） -> （i，j） // 向下走
 * 2）（i, j - 1） -> （i，j） //向右走
 * f(i, j) = max(f(i - 1, j), f(i, j - 1)) + gift[i][j]
 *
 * @author xing
 * @create 2021-03-30 16:59
 */
public class maxValue47 {
    public static int maxValue(int[][] grid) {
        //边界条件
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        // 创建dp table
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) // 防止边界值i == 0
                    up = dp[i - 1][j];
                if (j > 0)// 防止边界值j == 0
                    left = dp[i][j - 1];

                dp[i][j] = Math.max(left, up) + grid[i][j];
            }
        }
        int ans = dp[row - 1][col - 1];
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int ans = maxValue(grid);
        System.out.println(ans);

    }
}
