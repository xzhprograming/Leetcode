package dfs;

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

    private final int[][] dirArr = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 解法一：边界淹没法。
     *
     * 飞地指的是无法从陆地出发走到网格边界外的陆地。
     * 因此，所有和边界连通的陆地都不是飞地，可以先从四条边界开始 DFS，
     * 把这些陆地全部淹没为 0。最后矩阵中剩下的 1，就是无法离开边界的飞地。
     */
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // 先从上下边界出发，淹没所有与上下边界连通的陆地
        for(int i = 0; i < col; i++){
            floodBorderLand(grid, 0, i);
            floodBorderLand(grid, row - 1, i);
        }

        // 再从左右边界出发，淹没所有与左右边界连通的陆地
        for(int i = 0; i < row; i++){
            floodBorderLand(grid, i, 0);
            floodBorderLand(grid, i, col - 1);
        }
        int ans = 0;

        // 边界连通的陆地已经被置为 0，剩余的 1 都是飞地
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 将从 (i, j) 出发能连通到的所有陆地淹没为 0。
     */
    public void floodBorderLand(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }

        // 遇到海洋或已经淹没过的陆地，停止扩散
        if(grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;

        for(int[] dir : dirArr){
            floodBorderLand(grid, i + dir[0], j + dir[1]);
        }
    }

    // 边界是否有陆地1, true:有 false:没有
    boolean boundary = false;

    /**
     * 解法二：逐个岛屿统计。
     *
     * 每遇到一片陆地，就 DFS 统计这座岛的陆地数量，并记录它是否接触边界。
     * 如果整座岛没有接触边界，则把这座岛的面积加入答案。
     */
    public int numEnclavesByIslandCheck(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    boundary = false;
                    int count = countIslandAndCheckBoundary(grid, i, j);
                    if(!boundary){
                        ans += count;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 统计从 (i, j) 出发的连通陆地数量，并通过 boundary 记录这座岛是否接触边界。
     */
    public int countIslandAndCheckBoundary(int[][] grid, int i, int j){
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
        int up = countIslandAndCheckBoundary(grid, i - 1, j);

        // 下
        int bottom = countIslandAndCheckBoundary(grid, i + 1, j);

        // 左
        int left = countIslandAndCheckBoundary(grid, i, j - 1);

        // 右
        int right = countIslandAndCheckBoundary(grid, i, j + 1);
        return 1 + up + bottom + left + right;
    }
}
