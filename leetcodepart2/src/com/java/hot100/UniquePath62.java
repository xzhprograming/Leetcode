package com.java.hot100;

/**
 * 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 链接：https://leetcode-cn.com/problems/unique-paths
 *
 * @author xing
 * @create 2021-04-26 22:22
 */
public class UniquePath62 {

    // 深度遍历：超时
    int count = 0;

    public int uniquePaths(int m, int n) {
        dfs(m - 1, n - 1, 0, 0);
        return count;
    }

    public void dfs(int row, int col, int startRow, int startCol) {
        // 终止条件
        if (startRow > row || startCol > col) {
            return;
        }

        if (startRow == row && startCol == col)
            count += 1;
        dfs(row, col, startRow + 1, startCol);
        dfs(row, col, startRow, startCol + 1);
    }

    // 动态规划
    /*
    * 每一步只能从向下或者向右移动一步，因此要想走到 (i, j)(i,j)，
    * 如果向下走一步，那么会从 (i-1, j)(i−1,j) 走过来；如果向右走一步，那么会从 (i, j-1)(i,j−1) 走过来。
    * 因此我们可以写出动态规划转移方程：
        f(i, j) = f(i-1, j) + f(i, j-1)
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];

        // base case
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePath62 uq = new UniquePath62();
        System.out.println(uq.uniquePaths(10, 10));
    }
}
