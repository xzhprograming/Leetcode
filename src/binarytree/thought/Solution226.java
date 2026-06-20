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

    /**
     * 遍历的思想：先交换当前节点的左右子树，再继续处理左右孩子。
     *
     * @param root 当前遍历到的节点
     */
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

    /**
     * 分解问题的思想：先分别翻转左右子树，再把翻转后的结果交换位置。
     *
     * @param root 当前子树根节点
     * @return 翻转后的子树根节点
     */
    public TreeNode invertTreeV2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTreeV2(root.left);
        TreeNode right = invertTreeV2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
