package dfs;

/**
 * @author xingzihao
 * @description
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 思路1：记忆化dfs搜索
 * 思路2：dp
 * 思路3：组合数学，
 * @create 2025-04-26 20:46
 **/
public class Solution62 {

    public int uniquePaths(int m, int n) {
        // 记忆化递归搜索
        int[][] memory = new int[m][n];

        return dfs(0, 0, m, n, memory);
    }

    public int dfs(int row, int col, int m, int n, int[][] memory){
        if(row < 0 || col < 0 || row >= m || col >= n){
            return 0 ;
        }
        // 走到右下角
        if(row == m - 1 && col == n -1){
            return 1;
        }
        // 若已经计算过，则直接返回
        if(memory[row][col] != 0){
            return memory[row][col];
        }
        // 向下走
        int down = dfs(row + 1, col, m, n, memory);
        // 向右走
        int right = dfs(row, col + 1, m, n, memory);

        int res = down + right;
        // 存储计算结果
        memory[row][col] = res;
        return res;
    }


    /**
     * 动态规划
     * 达到i,j位置，可能从(i-1, j) 或者（i， j-1）到达
     * 则状态转移方程为：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];

        // base case
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    /**
     * 组合数学
     * 机器人只能向下或者向右移动，那么最后的移动路径为 类似：右右下右下
     * 从左上角到右下角的过程中，我们需要移动 m+n−2 次，其中有 m−1 次向下移动，n−1 次向右移动。
     * 因此路径的总数，就等于从 m+n−2 次移动中选择 m−1 次向下移动的方案数，即组合数C(m-1, m + n -2)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsMath(int m, int n) {
        long ans = 1;

        // 从m+n -2 开始计算，初始的乘积过大会溢出
//        for(int i = 1, j = m + n - 2; i < m; i++, j--){
//            ans = ans * j / i;
//        }
        // 分子从n开始，分母从1开始计算，防止溢出
         for (int x = n, y = 1; y < m; ++x, ++y) {
             ans = ans * x / y;
         }
        return (int) ans;
    }


    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        int i = solution62.uniquePathsMath(59, 5);
        System.out.println(i);
    }
}
