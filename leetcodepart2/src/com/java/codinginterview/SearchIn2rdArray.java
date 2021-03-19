package com.java.codinginterview;

/**
 * @author xing
 * @create 2021-03-19 20:23
 */
public class SearchIn2rdArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 边界条件:若数组为空,注意判空数组的写法
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0)
            return false;

        // 得到行数和列数
        int row = matrix.length;
        int col = matrix[0].length;

        int start_col = 0;
        int start_row = row - 1;

        while(start_row >= 0 && start_col < col){
            // 确定左下角的值
            int temp = matrix[start_row][start_col];
            // 重新划分查找区域
            if(temp < target){
                // 若左下角的值小于target，则列向右移
                start_col += 1;
            }
            else if (temp > target){
                // 若左下角的值大于target，则行向上移
                start_row -= 1;
            }
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{};
        SearchIn2rdArray si = new SearchIn2rdArray();
        System.out.println(si.findNumberIn2DArray(matrix, 2));
    }
}
