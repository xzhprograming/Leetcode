package com.java.binarytree;

import com.java.utils.TreeNode;

/**
 * @author xing
 * @create 2021-04-02 15:28
 */
public class JudgeAVL {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        // 后序遍历
        int left = height(root.left);
        int right = height(root.right);
        // 比较左右子树高度
        if(Math.abs(left - right) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 求二叉树深度
    public int height(TreeNode root){
        if(root == null)
            return 0;
        // 后序遍历
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }


    // 自底向上依次判断，防止重复遍历
    boolean flag = true;
    public boolean isBalanced1(TreeNode root) {
        height1(root);
        return flag;
    }

    // 求二叉树深度
    public int height1(TreeNode root){
        if(root == null)
            return 0;
        int left = height1(root.left);
        int right = height1(root.right);
        // 在遍历过程中进行判断，后序遍历自底向上进行判断
        if(Math.abs(left - right) > 1)
            flag = false;
        return Math.max(left, right) + 1;
    }
}
