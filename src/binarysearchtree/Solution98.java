package binarysearchtree;

import common.TreeNode;

import java.util.Stack;

/**
 * @author xingzihao
 * @description
 *
 * 思路：
 * way1:
 * 通过定义上下边界来辅助判断, lower < node < upper
 * 递归判断左右子树，对于每一个节点 root，root 的整个左子树都要小于 root.val，整个右子树都要大于 root.val。
 *
 * way2:
 * 利用BST的中序遍历序列有序来判断
 * 
 * @create 2025-02-25 23:22
 **/
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    // 通过定义上下边界来辅助判断, lower < node < upper
    public boolean isValidBST(TreeNode node, TreeNode lower, TreeNode upper) {
        // 空节点符合二叉搜索树要求
        if (node == null) {
            return true;
        }
        if (lower != null && node.val <= lower.val) {
            return false;
        }

        if(upper != null && node.val >= upper.val){
            return false;
        }

        // 递归遍历左子树，更新上界，即当前节点的值
        boolean left = isValidBST(node.left, lower, node);
        // 递归遍历左子树，更新下界，即当前节点的值
        boolean right = isValidBST(node.right, node, upper);
        return left && right;
    }


    /**
     * 利用 BST 的中序遍历序列严格递增来判断是否合法。
     *
     * 迭代模拟中序遍历，用 pre 记录上一个访问节点；
     * 如果当前节点值小于等于 pre，说明中序序列不递增，直接返回 false。
     *
     * 时间复杂度 O(n)，空间复杂度 O(h)，n 为节点数，h 为树高。
     *
     * @param root 二叉树根节点
     * @return 是否为合法二叉搜索树
     */
    public boolean isValidBST1(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if(pre != null && node.val <= pre.val){
                return false;
            }
            pre = node;
            cur = node.right;
        }
        return true;
    }
}
