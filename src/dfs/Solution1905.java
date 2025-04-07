package dfs;

/**
 * @author xingzihao
 * @description
 *
 * 1905. 统计子岛屿
 *
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 *
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
 *
 * 请你返回 grid2 中 子岛屿 的 数目 。
 *
 * 思路：
 * 1. 如果grid1[i][j] == 0 && grid2[i][j] == 1，那么该grid2的岛屿必然不是grid1的子岛屿，淹掉该岛屿
 * 2. 此时grid2中剩余的则都是grid1的子岛屿，dfs遍历获取
 * @create 2025-03-09 20:06
 **/
public class Solution1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length, m = grid2[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid1[i][j] == 0 && grid2[i][j] == 1){
                    // 这个岛屿肯定不是子岛，淹掉
                    dfs(grid2, i, j);
                }
            }
        }

        // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    public void dfs(int[][] grid, int i, int j){
        int n = grid.length, m = grid[0].length;
        // 超出索引边界
        if(i < 0 || j < 0 || i >= n || j >= m){
            return;
        }
        // 已经是海水了
        if(grid[i][j] == 0){
            return;
        }

        // 将 (i, j) 变成海水
        grid[i][j] = 0;
        // 淹没上下左右的陆地
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
