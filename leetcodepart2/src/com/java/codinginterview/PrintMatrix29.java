package com.java.codinginterview;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 解题思路：设置上下左右边界值
 * 从外向里打印一圈一圈打印
 * 打印方向为
 * 1.从左向右
 * 2.从上到下
 * 3.从右到左
 * 4.从下到上
 * @author xing
 * @create 2021-03-25 10:05
 */
public class PrintMatrix29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        // 设置边界值打印
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int  bottom= matrix.length - 1;

        int[] ans = new int[(right + 1) * (bottom + 1)];
        int size = 0;
        while(true){
            // 从左向右
            for(int i = left; i <= right; i++){
                ans[size++] = matrix[top][i];
            }
            if(++top > bottom) break;

            // 从上到下
            for(int i = top; i <= bottom; i++){
                ans[size++] = matrix[i][right];
            }
            if(--right < left) break;

            // 从右到左
            for(int i = right; i >= left; i--){
                ans[size++] = matrix[bottom][i];
            }
            if(--bottom < top) break;

            //从下到上
            for(int i = bottom; i >= top; i--){
                ans[size++] = matrix[i][left];
            }
            if(++left > right) break;
        }
        return ans;
    }
}
