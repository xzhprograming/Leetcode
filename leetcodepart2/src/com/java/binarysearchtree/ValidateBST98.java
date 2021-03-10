package com.java.binarysearchtree;

import com.java.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xing
 * @create 2021-03-10 22:09
 */
public class ValidateBST98 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while(root != null || stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    //非递归遍历树
    public void traverse(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                // TODO:preOrder
//                System.out.println(root);  //先序遍历
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // TODO:inOrder
//            System.out.println(root);  //中序遍历
            root = root.right;
        }
    }

    public void postOrder(TreeNode root){

    }

    public static void main(String[] args) {
        ValidateBST98 v = new ValidateBST98();
        TreeNode root = TreeNode.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        v.traverse(root);
    }
}
