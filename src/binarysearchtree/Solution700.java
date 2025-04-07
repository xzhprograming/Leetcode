package binarysearchtree;

import common.TreeNode;

/**
 * @author xingzihao
 * @description
 * 700. 二叉搜索树中的搜索
 *
 * 思路：
 *
 * @create 2025-02-26 23:10
 **/
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }


    TreeNode ans;
    public TreeNode searchBST1(TreeNode root, int val) {
        traverse(root, val);
        return ans;
    }

    public void traverse(TreeNode root, int val){
        if(root == null){
            return;
        }
        if(root.val == val){
            ans = root;
        } else if(root.val > val){
            traverse(root.left, val);
        } else{
            traverse(root.right, val);
        }
    }
}
