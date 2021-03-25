package com.java.codinginterview;

import com.java.utils.TreeNode;

/**
 *剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @author xing
 * @create 2021-03-24 19:40
 */
public class TreeStruct26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //1. 找到A与B val相同的节点
        // 2. 比较相同的节点的结构
        // 3.相同结构的节点有可能以A或A.left或A.right为根节点，找到一个即可
        // 边界条件
        if(A == null || B == null)
            return false;
        boolean root = helper(A, B); // 以节点A为根节点进行判断
        boolean left = isSubStructure(A.left, B);  //以节点A的左节点为根节点进行判断
        boolean right = isSubStructure(A.right, B); //以节点A的右节点为根节点进行判断
        return root || left || right;
    }

    // 比较两个节点是否具有相同的结构
    public boolean helper(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null || root1.val != root2.val)
            return false;
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}
