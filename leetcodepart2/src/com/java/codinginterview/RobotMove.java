package com.java.codinginterview;

import java.util.Scanner;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * @author xing
 * @create 2021-03-21 16:47
 */
public class RobotMove {

    public static int movingCount(int m, int n, int k) {
        // 有可能从（0,0）到其他方格的位置被阻塞
        //回溯法：暴力穷举所有满足条件的格子
        // 把方格分为可到达和阻塞的格子
        boolean[][] visited = new boolean[m][n]; // 初始化所有的方格为未访问状态
        return backtrack(0, 0, m, n, k, visited);
    }

    public static int backtrack(int row, int col, int m, int n, int k, boolean[][] visited) {
        int count = 0;
        if (checkVaild(row, col, m, n, k, visited)) {
            visited[row][col] = true;
            return 1 + backtrack(row + 1, col, m, n, k, visited) + backtrack(row - 1, col, m, n, k, visited) +
                    backtrack(row, col + 1, m, n, k, visited) + backtrack(row, col - 1, m, n, k, visited);
        }
        return count;
    }

    public static boolean checkVaild(int row, int col, int m, int n, int k, boolean[][] visited) {
        // 触发终止条件
        if (row < 0 || col < 0 || row >= m || col >= n || numSum(row, col) > k || visited[row][col])
            return false;
        return true;
    }

    // 求数位之和
    public static int numSum(int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }

        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = movingCount(m, n, k);
        System.out.println(ans);
    }
}
