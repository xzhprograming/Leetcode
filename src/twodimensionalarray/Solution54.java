package twodimensionalarray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 54.螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 思路：
 * 模拟遍历：
 * // 从左到右
 * // 从上到下
 * // 从右到左
 * // 从下到上
 * @create 2025-03-26 00:00
 **/
public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> list = new ArrayList<>();
        while(true){
            // 从左到右
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            if(top > bottom){
                break;
            }
            // 从上到下
            for(int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(right < left){
                break;
            }
            // 从右到左
            for(int i = right; i >= left; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(bottom < top){
                break;
            }
            // 从下到上
            for(int i = bottom; i >= top; i--){
                list.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }
        }


        return list;
    }
}
