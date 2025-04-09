package binarytree;

import common.TreeNode;

/**
 * @author xingzihao
 * @description
 *
 * 104. 二叉树的最大深度
 * @create 2025-04-09 23:27
 **/
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
