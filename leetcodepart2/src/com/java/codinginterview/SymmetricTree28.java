package com.java.codinginterview;

import com.java.utils.TreeNode;

/**101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author xing
 * @create 2021-03-24 22:47
 */
public class SymmetricTree28 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2){
        // TLR 遍历和TRL遍历得到的序列是相等的，则二叉树对称
        // 其中遍历序列中有一个不同则为非对称
        // 终止条件
        // 情况1：两个节点都为空
        if(root1 == null && root2 == null){
            return true;
        }
        // 情况2：其中一个节点不为空，即两个节点不相等
        if(root1 == null || root2 == null){
            return false;
        }
        // 情况3：两个节点不相等
        if(root1.val != root2.val){
            return false;
        }
        // 判断两节点 L.leftL.left 和 R.rightR.right 是否对称
        boolean left = isSymmetric(root1.left, root2.right);
        // 判断两节点 L.rightL.right 和 R.leftR.left 是否对称
        boolean right = isSymmetric(root1.right, root2.left);
        return left && right;
    }
}
