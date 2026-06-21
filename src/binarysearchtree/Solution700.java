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

    /**
     * 迭代法搜索 BST。
     *
     * 利用 BST 的有序性，每次只进入可能包含目标值的一侧子树：
     * 当前节点值大于 val 时去左子树，否则去右子树。
     *
     * 时间复杂度 O(h)，空间复杂度 O(1)，h 为树高。
     *
     * @param root 二叉搜索树根节点
     * @param val 目标值
     * @return 以目标值节点为根的子树；不存在时返回 null
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null){
            if(root.val == val){
                return root;
            } else if(root.val > val){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
