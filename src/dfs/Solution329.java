package dfs;

/**
 * @author xingzihao
 * @description
 * 329.矩阵中的最长递增路径
 *
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 * 思路：
 * 记忆化深度优先搜索
 * 1. 创建一个memo数组，用来记录每个位置的最长递增路径
 * 2. 对每一个位置进行DFS,并存储其相应的最长递增路径长度
 * 3. 更新最长递增路径长度
 * @create 2025-05-04 15:27
 **/
public class Solution329 {

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memo = new int[row][col];

        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ans = Math.max(ans, dfs(matrix, row, col, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int col,int i, int j, int[][] memo){
        if(i >= row || j >= col || i < 0 || j < 0){
            return 0;
        }

        if(memo[i][j] != 0){
            return memo[i][j];
        }

        int cur = matrix[i][j];

        int up = 0;
        if(i - 1 >=0 && matrix[i - 1][j] > cur){
            up = dfs(matrix, row, col, i - 1, j, memo);
        }
        int down = 0;
        if(i + 1 < row && matrix[i + 1][j] > cur){
            down = dfs(matrix, row, col, i + 1, j, memo);
        }
        int left = 0;
        if(j - 1 >=0 && matrix[i][j - 1] > cur){
            left = dfs(matrix, row, col, i, j - 1, memo);
        }
        int right = 0;
        if(j + 1 < col && matrix[i][j + 1] > cur){
            right = dfs(matrix, row, col, i, j + 1, memo);
        }
        memo[i][j] = 1 + Math.max(up, Math.max(down, Math.max(left, right)));
        return memo[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{7,8,9},{9,7,6},{7,2,3}};
        Solution329 solution329 = new Solution329();
        int ans = solution329.longestIncreasingPath(matrix);
        System.out.println(ans);
    }
}
