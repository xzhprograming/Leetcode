package com.java.binarysearchtree;

import com.java.utils.TreeNode;

/**
 * @author xing
 * @create 2021-03-11 15:42
 */
public class DeleteInBST {
    private static class Solution{
        TreeNode deleteNode(TreeNode root, int key) {
            // 边界条件
            if (root == null) return null;
            if (root.val == key) {
                //TODO:delete
                // 情况1：要删除的节点左右子树都为空
                if(root.left == null && root.right == null){
                    return null;
                }
                // 情况2：要删除的节点左子树或右子树为空
                if(root.left == null)
                    return root.right;
                if(root.right == null)
                    return root.left;
                // 情况3：要删除的节点左子树和右子树都不为空
                //返回右子树的最小节点，因为右子树中的最小节点都大于左子树的节点，
                // 所以用此节点填充当前删除的位置
                TreeNode minRightNode = getMin(root.right);

                root.val = minRightNode.val;
                root.right = deleteNode(root.right, minRightNode.val);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        TreeNode getMin(TreeNode node) {
            // BST 最左边的就是最小的
            while (node.left != null) node = node.left;
            return node;
        }
    }
}
