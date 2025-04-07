package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 1020. 飞地的数量
 *给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 * 思路：
 * 用一个全局变量记录在dfs的过程中是否遍历到边界，且边界有1
 *
 * 在最后记录结果的时候，不记录边界为1的情况即可
 * @create 2025-03-09 19:49
 **/
public class Solution1020 {

    // 边界是否有陆地1, true:有 false:没有
    boolean boundary = false;
    // 深度搜索，将查找过的岛屿，附近的陆地置为’0‘， 防止重复计算
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    boundary = false;
                    int count = dfs(grid, i, j);
                    if(!boundary){
                        ans += count;
                    }
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j){
        // 如果边界上有1，则说明可以到达边界，记录下来，待最后判断
        if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1){
            if(i >= 0 && j >= 0 && i <= grid.length - 1 && j <= grid[0].length - 1 && grid[i][j] == 1){
                boundary = true;
            }
        }

        // 超出边界，或者遍历到水的位置，则退出
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0 ;
        }

        grid[i][j] = 0;

        // 上
        int up = dfs(grid, i - 1, j);

        // 下
        int bottom = dfs(grid, i + 1, j);

        // 左
        int left = dfs(grid, i, j - 1);

        // 右
        int right = dfs(grid, i, j + 1);
        return 1 + up + bottom + left + right;
    }
}
