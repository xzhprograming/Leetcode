package dfs;

/**
 * @author xingzihao
 * @description
 * 二维矩阵 DFS 遍历示例。
 *
 * 使用 visited 数组记录已经遍历过的位置，从 (0, 0) 开始按照上、下、左、右的顺序访问相邻节点。
 */
public class MatrixDfsPrinter {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        dfs(grid, 0, 0, visited);
    }

    // 二维矩阵遍历框架
    public static void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (visited[i][j]) {
            // 已遍历过 (i, j)
            return;
        }

        // 进入当前节点 (i, j)
        visited[i][j] = true;
        System.out.println("grid[" + i + "][" + j + "] = " + grid[i][j]);

        // 进入相邻节点（四叉树）
        // 上
        dfs(grid, i - 1, j, visited);
        // 下
        dfs(grid, i + 1, j, visited);
        // 左
        dfs(grid, i, j - 1, visited);
        // 右
        dfs(grid, i, j + 1, visited);
    }
}
