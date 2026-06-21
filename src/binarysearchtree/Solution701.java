package binarysearchtree;

import common.TreeNode;

/**
 * @author xingzihao
 * @description
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * @create 2026-06-21 17:07
 **/
public class Solution701 {

    /**
     * 递归法插入新节点。
     *
     * 根据 BST 的有序性向左或向右递归，直到遇到空位置后创建新节点；
     * 递归返回时重新挂接子树根节点，保持原树结构不丢失。
     *
     * 时间复杂度 O(h)，空间复杂度 O(h)，h 为树高。
     *
     * @param root 二叉搜索树根节点
     * @param val 待插入的新值，题目保证不与现有节点重复
     * @return 插入新节点后的根节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }


    /**
     * 迭代法插入新节点。
     *
     * 从根节点开始向下查找第一个可插入的空子节点位置，
     * 小于当前节点则进入左子树，大于当前节点则进入右子树。
     *
     * 时间复杂度 O(h)，空间复杂度 O(1)，h 为树高。
     *
     * @param root 二叉搜索树根节点
     * @param val 待插入的新值，题目保证不与现有节点重复
     * @return 插入新节点后的根节点
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode newNode = new TreeNode(val);
        while(cur != null){
            if(cur.val < val){
                if(cur.right == null){
                    cur.right = newNode;
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                if(cur.left == null){
                    cur.left = newNode;
                    break;
                } else {
                    cur = cur.left;
                }
            }
        }
        return root;
    }
}
