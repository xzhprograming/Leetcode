package com.java.hot100;

import java.util.*;

/**
 * @className: LandsNum
 * @description: 200、岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 解题思路：
 * DFS:找到网格中为1的位置，记录岛屿数+1，搜索其上下左右四个方向，并将其位置置为0
 * BFS:
 * @author: xingzihao
 * @date: 2021/10/10
 **/
public class LandsNum {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        LandsNumSolution2 landsNumSolution2 = new LandsNumSolution2();
        int numIslands = landsNumSolution2.numIslands(grid);
        System.out.println(numIslands);
    }
}

class LandsNumSolution1 {
    public int numIslands(char[][] grid) {
        // 解题思路：找到网格中为1的位置，记录岛屿数+1，搜索其上下左右四个方向，并将其位置置为0
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int row, int col) {
        grid[i][j] = '0';

        if (i + 1 < row && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j, row, col);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j, row, col);
        }
        if (j + 1 < col && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1, row, col);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1, row, col);
        }
    }
}

class LandsNumSolution2 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            i = tmp[0];
            j = tmp[1];
            if (0 <= i && i < row && 0 <= j && j < col && grid[i][j] == '1') {
                grid[i][j] = '0';
                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i - 1, j});
                queue.offer(new int[]{i, j - 1});
                queue.offer(new int[]{i, j + 1});
            }
        }
    }
}