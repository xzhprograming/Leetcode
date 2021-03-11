package com.java.binarysearchtree;

import com.java.utils.TreeNode;

/**
 * @author xing
 * @create 2021-03-11 15:46
 */
public class BSTFrame {
    // 进行BST的增删改查
    void BST(TreeNode root, int target) {
        if (root.val == target)
            // 找到目标，做点什么
        if (root.val < target)
            BST(root.right, target);
        if (root.val > target)
            BST(root.left, target);
    }
}
