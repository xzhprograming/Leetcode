package binarysearchtree;

import common.TreeNode;

/**
 * @author xingzihao
 * @description
 *
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * 思路：
 * 1. 利用BST的左子树节点 < 根节点 < 右子树节点，来分别判断各种情况
 * 2. 当找到删除节点后的四种情况的分别处理
 * 3. 利用二叉树的递归特性，分别递归并处理左右子树
 * @create 2025-02-27 23:18
 **/
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        // 删除节点四种情况
        if(root.val == key){
            // 左右子树都为空
            if(root.left == null && root.right == null){
                return null;
            }
            // 左子树为空
            if(root.left == null){
                return root.right;
            }
            // 右子树为空
            if(root.right == null){
                return root.left;
            }

            // 左右子树都不为空
            // 如果该节点的右子树的左子树节点不为null, 则需要找到最小的那个左子树节点，否则返回该节点的右子树
            // 并且该节点的右子树需要删除该节点
            TreeNode minNode = findMinNode(root.right, root.val);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
            // 不是简单的将minNode节点的值赋给root节点，而是利用节点之间的指向来处理
//            minNode.left = root.left;
//            minNode.right = root.right;
//            root = minNode;
        } else if (root.val > key){
            root.left = deleteNode(root.left, key);
        } else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode findMinNode(TreeNode node, int key){
        if(node.left == null){
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
