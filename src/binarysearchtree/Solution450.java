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


    /**
     * 迭代法删除 BST 中的目标节点。
     *
     * 先沿 BST 搜索路径找到目标节点及其父节点，再按删除节点的子树数量分情况处理：
     * 1. 无子节点：直接置空；
     * 2. 只有一个子节点：用唯一子节点补位；
     * 3. 左右子树都存在：用右子树中的最小节点（中序后继）补位。
     *
     * 时间复杂度 O(h)，空间复杂度 O(1)，h 为树高。
     *
     * @param root 二叉搜索树根节点
     * @param key 待删除的节点值
     * @return 删除目标节点后的根节点
     */
    public TreeNode deleteNode1(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        TreeNode cur = root;
        TreeNode curParent = null;
        while(cur != null){
            if(cur.val == key){
                break;
            }
            curParent = cur;
            if(cur.val > key){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if(cur == null){
            return root;
        }

        if(cur.left == null && cur.right == null){
            cur = null;
        } else if(cur.left == null){
            cur = cur.right;
        } else if(cur.right == null){
            cur = cur.left;
        } else {
            // 找到右子树的最左节点作为中序后继，用它补到被删除节点的位置。
            TreeNode successor = cur.right;
            TreeNode successorParent = cur;
            if(successor.left == null){
                // 右子节点本身就是后继，先把后继从原位置摘下。
                successorParent.right = successor.right;
            } else {
                while(successor.left != null){
                    successorParent = successor;
                    successor = successor.left;
                }
                // 后继最多只有右子树，将其右子树接回后继父节点的左侧。
                successorParent.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }

        if(curParent == null){
            return cur;
        } else {
            if(curParent.left != null && curParent.left.val == key){
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
        }
        return root;
    }
}
