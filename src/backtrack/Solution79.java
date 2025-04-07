package backtrack;

/**
 * @author xingzihao
 * @description
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 深度优先搜索： 即暴力法遍历矩阵中所有字符串可能性。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
 * 剪枝： 在搜索中，遇到“这条路不可能和目标字符串匹配成功”的情况，例如当前矩阵元素和目标字符不匹配、
 * 或此元素已被访问，则应立即返回，从而避免不必要的搜索分支。
 *
 * @create 2025-03-10 22:45
 **/
public class Solution79 {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        // 记录节点是否被访问过
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(board, 0, word, i, j,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int start, String word, int i, int j, boolean[][] visited){
        // 边界条件
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || start >= word.length()){
            return false;
        }
        // 节点被访问过
        if(visited[i][j]){
            return false;
        }
        // 节点不符合条件
        if(board[i][j] != word.charAt(start)){
            return false;
        }
        // 节点满足条件
        if(start == word.length() - 1){
            return true;
        }

        // 做出决策
        visited[i][j] = true;
        boolean up = dfs(board, start + 1, word, i - 1 ,j, visited);
        boolean bottom = dfs(board, start + 1, word, i + 1 ,j, visited);
        boolean left = dfs(board, start + 1, word, i ,j - 1, visited);
        boolean right = dfs(board, start + 1, word, i,j + 1, visited);

        // 最终结果判断
        boolean res = up || bottom || left || right;
        // 撤销决策，回溯到上一个节点
        visited[i][j] = false;

        return res;
    }


    /**
     * 不使用visited数组
     * @param board
     * @param word
     * @return
     */
    public boolean exist1(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs1(board, 0, word, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs1(char[][] board, int start, String word, int i, int j){
        // 边界条件
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || start >= word.length()){
            return false;
        }
        // 节点不符合条件
        if(board[i][j] != word.charAt(start)){
            return false;
        }
        // 节点满足条件
        if(start == word.length() - 1){
            return true;
        }

        // 做出决策
        board[i][j] = '\0';
        boolean up = dfs1(board, start + 1, word, i - 1 ,j);
        boolean bottom = dfs1(board, start + 1, word, i + 1 ,j);
        boolean left = dfs1(board, start + 1, word, i ,j - 1);
        boolean right = dfs1(board, start + 1, word, i,j + 1);

        // 最终结果判断
        boolean res = up || bottom || left || right;
        // 撤销决策，回溯到上一个节点
        board[i][j] = word.charAt(start);

        return res;
    }

}
