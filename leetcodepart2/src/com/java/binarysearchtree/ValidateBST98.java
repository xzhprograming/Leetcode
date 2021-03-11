package com.java.binarysearchtree;

import com.java.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xing
 * @create 2021-03-10 22:09
 */
public class ValidateBST98 {
    //解题思路：利用BST的中序遍历特性，即中序遍历为升序序列
    //使用inOrder的非递归遍历方式（Stack）进行判断
    public boolean isValidBST(TreeNode root) {
        //特殊情况：当树为空的时候也返回true

        Deque<TreeNode> stack = new LinkedList<>();
        long min = Long.MIN_VALUE;
        double min_value = -Double.MAX_VALUE;
        //遍历终止条件
        while(!stack.isEmpty() || root != null){
            //先将当前节点的左子树压入栈中
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //弹出树节点
            root = stack.pop();
            //TODO
            //// 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if(root.val <= min)
                return false;
            min = root.val; // 更新最小值
            root = root.right;
        }
        return true;
    }
    //递归实现
    boolean isValidBST1(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
    //非递归遍历树
    public void traverse(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                // TODO:preOrder
//                System.out.println(root);  //先序遍历
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // TODO:inOrder
//            System.out.println(root);  //中序遍历
            root = root.right;
        }
    }

    public void postOrder(TreeNode root){

    }

    public static void main(String[] args) {
        ValidateBST98 v = new ValidateBST98();
        TreeNode root = TreeNode.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        v.traverse(root);
    }
}
