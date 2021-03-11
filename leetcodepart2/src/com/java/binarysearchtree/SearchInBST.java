package com.java.binarysearchtree;

import com.java.utils.TreeNode;

/**
 * @author xing
 * @create 2021-03-11 11:42
 */
public class SearchInBST {
    private static class Solution {
        //解题思路：利用二叉树的顺序
        TreeNode res = null;
        public TreeNode searchBST(TreeNode root, int val) {
            search(root, val);
            return res;
        }
        public void search(TreeNode root, int val){
            //边界条件
            if(root == null){
                return;
            }
            if (root.val < val){
                searchBST(root.right, val);
            }
            else if(root.val > val){
                searchBST(root.left, val);
            }
            else{
                res = root;
                return;
            }
        }

        public TreeNode searchBST1(TreeNode root, int val) {
            while (root != null){
                if (root.val == val){
                    return root;
                }
                else if (root.val < val){
                    root = root.right;
                }
                else{
                    root = root.left;
                }
            }
            return root;
        }
        public TreeNode searchBST2(TreeNode root, int val) {
            while (root != null && root.val != val){
                root = root.val < val ? root.right : root.left;
            }
            return root;
        }
    }

    public static void main(String[] args) {

    }
}