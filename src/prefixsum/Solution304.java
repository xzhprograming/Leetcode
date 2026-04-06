package prefixsum;

import java.util.Arrays;

/**
 * @author xingzihao
 * @description
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 *
 * @create 2026-04-06 18:06
 **/
public class Solution304 {
    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
    }
}

class NumMatrix {

    int[][] preSumMatrix;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        preSumMatrix = new int[row + 1][col + 1];
        // 初始化前缀和
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++)
                preSumMatrix[i][j] = preSumMatrix[i - 1][j] + preSumMatrix[i][j - 1] - preSumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
        for(int i = 0; i < preSumMatrix.length; i++){
            System.out.println(Arrays.toString(preSumMatrix[i]));
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSumMatrix[row2 + 1][col2 + 1] - preSumMatrix[row1][col2 + 1] - preSumMatrix[row2 + 1][col1] + preSumMatrix[row1][col1];
    }
}

