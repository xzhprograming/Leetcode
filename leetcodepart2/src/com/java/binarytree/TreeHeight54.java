package com.java.binarytree;

import com.java.utils.TreeNode;

/**
 * @author xing
 * @create 2021-04-02 15:28
 */
public class TreeHeight54 {
    // 求二叉树深度
    public int height(TreeNode root){
        if(root == null)
            return 0;
        // 后序遍历
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
}
