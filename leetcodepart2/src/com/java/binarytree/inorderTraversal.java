package com.java.binarytree;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 返回二叉树的中序遍历序列 （以中序序列：4，2，5，1，6，3 为例）
 * 递归和非递归写法
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class inorderTraversal {
    // 非递归写法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){ //这里包含了两种情况，当前节点不为空或者栈不为空(当前节点为空证明已经到达某个边界；当前栈为空，证明已经遍历完毕)
            while(root!=null){ // 如果当前节点不为空，就将当前节点入栈，并循环遍历其左子树，直至叶子节点
                stack.push(root);
                root = root.left;
            }
            root=stack.pop(); // 如果遍历到了叶子节点就弹出当前节点
            list.add(root.val); // 将当前节点加入到list中
            root = root.right;  // 查看当前节点的右子树是不是为空，如果为空，就继续弹栈，如果不为空就将右子树入栈，并继续查找右子树的左子树，依次递进
        }
        return list;
    }


    // 递归写法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list,root);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if(root==null){
            return;
        }
        dfs(list,root.left);
        list.add(root.val);
        dfs(list, root.right);
    }
}
