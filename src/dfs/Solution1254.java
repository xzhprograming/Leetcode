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

    // 深度搜索，将查找过的岛屿及其连通陆地置为 1，防止重复计算
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
     * 判断岛屿是否封闭。
     *
     * grid 中 0 表示陆地，1 表示水。
     * - 如果从陆地一路搜索到矩阵外，说明这座岛与边界连通，不是封闭岛，返回 false。
     * - 如果当前位置不是陆地，说明走到了水，或者走到了已经访问过并被标记成 1 的陆地；
     *   这两种情况都不会破坏封闭性，所以返回 true。
     * - 当前陆地的上下左右四个方向都返回 true 时，整座岛才是封闭岛。
     */
    public boolean dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            // 搜索越界，说明岛屿连到了矩阵边界外，不封闭
            return false;
        }

        if(grid[i][j] != 0){
            // 走到水或已访问过的位置，说明这个方向被挡住了，不会导致岛屿开放
            return true;
        }

        // 标记当前陆地已访问，后续再次遇到它时按水处理，避免重复遍历
        grid[i][j] = 1;

        // 上
        boolean up = dfs(grid, i - 1, j);

        // 下
        boolean bottom = dfs(grid, i + 1, j);

        // 左
        boolean left = dfs(grid, i, j - 1);

        // 右
        boolean right = dfs(grid, i, j + 1);

        // 四个方向都被水或已访问区域挡住，没有任何方向越界，才是封闭岛
        return up && bottom && left && right;
    }

    /**
     * 解法二：先外后内。
     *
     * 封闭岛屿不能和矩阵边界连通，所以可以先从四条边界出发，
     * 把所有与边界连通的陆地全部淹掉。剩下仍然为 0 的陆地，
     * 就一定是被水包围的封闭岛屿。
     */
    public int closedIslandByFloodBorder(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // 先遍历上下边界，把边界上以及与边界相连的陆地全部置为 1
        for(int i = 0; i < col; i++){
            floodBorderLand(grid, 0, i);
            floodBorderLand(grid, row - 1, i);
        }

        // 再遍历左右边界，继续消除与边界连通的陆地
        for(int i = 0; i < row; i++){
            floodBorderLand(grid, i, 0);
            floodBorderLand(grid, i, col - 1);
        }

        int count = 0;
        // 边界连通的陆地已经被淹掉，内部剩下的每一片陆地都是封闭岛
        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < col - 1; j++){
                if(grid[i][j] == 0){
                    count++;
                    floodBorderLand(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 将从 (i, j) 出发能连通到的所有陆地置为 1。
     *
     * 这个方法只负责“淹掉一片陆地”，不返回封闭性判断结果；
     * 因此和解法一中返回 boolean 的 dfs 分开命名，避免方法签名冲突。
     */
    public void floodBorderLand(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }

        // 遇到水或已经访问过的位置，直接停止扩散
        if(grid[i][j] == 1){
            return;
        }

        // 将当前陆地淹掉，防止后续重复统计
        grid[i][j] = 1;

        floodBorderLand(grid, i - 1, j);
        floodBorderLand(grid, i + 1, j);
        floodBorderLand(grid, i, j - 1);
        floodBorderLand(grid, i, j + 1);
    }

}
