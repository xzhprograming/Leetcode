package com.java.hot100;

/**
 * @className: MaxSquare221
 * @description:
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 解题思路：
 * 1. 暴力法：
 * 遍历每一个为1的位置，以其作为左上角，每次新增一行一列，判断新增的行列是否为1，
 * 寻找最大正方形，得到最大正方形边长即可得到其面积
 *
 * 2. 动态规划
 * 我们用dp(i,j) 表示以 (i, j) 为右下角，且只包含1的正方形的边长最大值。如果我们能计算出所有 dp(i,j) 的值，
 * 那么其中的最大值即为矩阵中只包含 1 的正方形的边长最大值，其平方即为最大正方形的面积。
 *
 *如何计算 dp 中的每个元素值?
 * 对于每个位置 (i, j)(i,j)，检查在矩阵中该位置的值：
 * 如果该位置的值是 0，则 dp(i,j)=0，因为当前位置不可能在由 1 组成的正方形中；
 * 如果该位置的值是 1，则 dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。
 * 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下
 * dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
 *
 * 边界条件：
 * 如果 i 和 j 中至少有一个为 0，则以位置 (i, j) 为右下角的最大正方形的边长只能是 1，因此 dp(i,j)=1
 *
 * @author: xingzihao
 * @date: 2021/10/11
 **/
public class MaxSquare221 {
}
class MaxSquareSolution1 {
    public int maximalSquare(char[][] matrix) {
        // 暴力法：
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    // 更新最大正方形边长
                    maxSide = Math.max(maxSide, 1);
                    // 计算现有可能最大正方形的边长
                    int side = Math.min(row - i, col - j);
                    for(int k = 1; k < side; k++){
                        // 依次判断新增的一行一列是否均为 1
                        boolean flag = true;
                        if(matrix[i + k][j + k] == '0'){
                            break;
                        }
                        for(int m = 0; m < k; m++){
                            if(matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            maxSide = Math.max(maxSide, k + 1);
                        } else{
                            break;
                        }
                    }
                }
            }
        }
        int area = maxSide * maxSide;
        return area;
    }
}

class MaxSquareSolution2 {
    public int maximalSquare(char[][] matrix) {
        // 动态规划：
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    // base case
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}