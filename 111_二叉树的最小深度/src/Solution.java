import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * @author xing
 * @create 2021-03-06 15:19
 */

public class Solution {
//    1.使用BFS不断更新二叉树的深度，取其最小值。
    public int minDepth(TreeNode root){
        //特殊情况，根节点为空
        if(root == null)
            return 0;

        int mindepth = 1; //设置最小深度

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root); // 添加首节点
        while (!qu.isEmpty()){ //若队列非空
            int sz = qu.size();// 记录当前队列的长度
            for (int i = 0; i < sz; i++){
                TreeNode firstNode = qu.poll();
                // 到达距离根节点最近的叶子节点，则此条路径最短
                if (firstNode.left == null && firstNode.right == null)
                    return mindepth;
                //添加非空子节点
                if (firstNode.left != null){
                    qu.offer(firstNode.left);
                }
                if (firstNode.right != null){
                    qu.offer(firstNode.right);
                }
            }
            mindepth++; //更新最小深度
        }
        return mindepth;
    }

    //2.使用DFS不断更新二叉树的深度，取其最小值。
    //当前节点的最小深度为其左节点和右节点的最小深度，即min(root) = min(root.left, root.right)
    public int minDepth1(TreeNode root){
        int mindepth = Integer.MAX_VALUE;
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) //叶子节点
            return 1;
        if (root.left != null)
//            mindepth = mindepth <= minDepth1(root.left) ? mindepth : minDepth1(root.left); // 超时，可能需要执行两次minDepth1(root.left)？？？
            mindepth = Math.min(mindepth, minDepth1(root.left));
        if (root.right != null)
            mindepth = Math.min(mindepth, minDepth1(root.right));
        return mindepth + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // TODO：构建二叉树：
        //  1，前序遍历和中序遍历构建二叉树
        //  2. 层次遍历构建二叉树？？？
        TreeNode root = new TreeNode(2);
        solution.minDepth(root);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}