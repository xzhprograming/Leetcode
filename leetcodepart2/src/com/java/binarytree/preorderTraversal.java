package com.java.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author GZDX    2021-04-08-21:53
 */
public class preorderTraversal {
    // 递归
    public void preorderTraversal1(TreeNode root){
        System.out.println(root);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
    }

    // 非递归
    public void preorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop(); //
            System.out.println(tmp); // 访问
            if(tmp.right!=null){ // 将右节点压栈
                stack.push(tmp.right);
            }
            if(tmp.left!=null){ // 将左节点压栈
                stack.push(tmp.left);
            }
        }
    }
}
