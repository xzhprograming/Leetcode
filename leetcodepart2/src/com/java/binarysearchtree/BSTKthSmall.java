package com.java.binarysearchtree;

import com.java.utils.TreeNode;

/**
 * @author xing
 * @create 2021-03-09 22:22
 */
public class BSTKthSmall {
    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        System.out.println(so.kthSmallest(root, 3));
    }
}

class Solution {
    int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.right, k);
    }
}
