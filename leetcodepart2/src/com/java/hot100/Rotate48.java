package com.java.hot100;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * 给定一个 n×n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 链接：https://leetcode-cn.com/problems/rotate-image
 *
 * @author xing
 * @create 2021-04-22 20:37
 */
public class Rotate48 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix == null)
            return;

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] ans = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
//                ans[j][row - 1 - i] = matrix[i][j];
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void testCopy(int[] copy){
        int[] reverse = new int[copy.length];

        for(int i = copy.length - 1; i >= 0; i--){
            reverse[copy.length - 1 - i] = copy[i];
        }

        for (int i = 0; i < copy.length; i++){
            copy[i] = reverse[i];
        }
    }

    public static void main(String[] args) {
        Rotate48 r = new Rotate48();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        r.rotate(matrix);
//        System.out.println(Arrays.deepToString(matrix));

        /*
        int[] tmpForCopy = new int[]{1,2,3,4,5,6};
        testCopy(tmpForCopy);
        System.out.println(Arrays.toString(tmpForCopy));
         */
    }
}
