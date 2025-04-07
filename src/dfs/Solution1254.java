package dfs;

/**
 * @author xingzihao
 * @description
 * 1254. 统计封闭岛屿的数目
 *
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，
 * 封闭岛是一个 完全 由1包围（左、上、右、下）的岛。请返回 封闭岛屿 的数目。
 *
 *
 * 思路：
 * 1. 从土地开始遍历，并判断当前位置所在的是否为封闭岛屿，并在遍历过程中，将遍历过的岛屿置为1，
 * @create 2025-03-09 19:11
 **/
public class Solution1254 {

    // 深度搜索，将查找过的岛屿，附近的陆地置为’0‘， 防止重复计算
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && dfs(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     判断岛屿是否封闭
     */
    public boolean dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return false;
        }

        if(grid[i][j] != 0){
            return true;
        }

        grid[i][j] = 1;

        // 上
        boolean up = dfs(grid, i - 1, j);

        // 下
        boolean bottom = dfs(grid, i + 1, j);

        // 左
        boolean left = dfs(grid, i, j - 1);

        // 右
        boolean right = dfs(grid, i, j + 1);

        return up && bottom && left && right;
    }
}
