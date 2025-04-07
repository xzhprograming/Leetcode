package binarytree.thought;

import common.TreeNode;
/**
 * @author xingzihao
 * @description
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @create 2025-02-23 16:00
 **/
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        traverse(root.left);
        traverse(root.right);
    }
}
