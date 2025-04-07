package twodimensionalarray;

/**
 * @author xingzihao
 * @description
 *
 * 48. 旋转图像
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 思路：
 * 关键点：旋转后的元素关系有如下等式：
 * matrix[col][n−row−1]=matrix[row][col]
 *
 * 水平旋转后：matrix[row][col] = matrix[n - row - 1][col];
 * 对角线翻转后：matrix[row][col] = matrix[col][row];
 * 可推导出 => matrix[col][n−row−1]=matrix[row][col]
 * @create 2025-02-16 19:50
 **/
public class Solution48 {

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        // 先水平翻转，再沿对角线翻转
        int n = matrix.length;

        // 水平翻转
        // matrix[row][col] = matrix[n - row - 1][col];
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        // 对角线翻转
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
