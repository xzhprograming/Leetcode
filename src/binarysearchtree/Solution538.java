package binarysearchtree;

import common.TreeNode;

/**
 * @author xingzihao
 * @description
 *
 * 538. 把二叉搜索树转换为累加树
 *
 * 思路：
 * 降序获取 BST 节点的值，维护一个外部累加变量 sum，然后把 sum 赋值给 BST 中的每一个节点，即可将BST 转化成累加树
 *
 * @create 2025-03-02 19:11
 **/
public class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        sumBST(root);
        return root;
    }

    // 需要一直记录累加和，传递到各个节点
    int sum = 0;
    public void sumBST(TreeNode root){
        if(root == null){
            return;
        }

        sumBST(root.right);
        sum += root.val;
        root.val = sum;
        sumBST(root.left);
    }
}
