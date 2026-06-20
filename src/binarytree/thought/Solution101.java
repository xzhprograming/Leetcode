package binarytree.thought;

import common.TreeNode;

/**
 * @author xingzihao
 * @description
 * 101. 对称二叉树
 * 判断一棵二叉树是否轴对称。
 * @create 2026-06-20 17:34
 **/
public class Solution101 {
    /**
     * 从根节点的左右子树开始，递归比较镜像位置上的两个节点。
     *
     * @param root 二叉树根节点
     * @return true 表示二叉树关于根节点对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    /**
     * 对称判断的核心：
     * 左子树的左节点要和右子树的右节点相等，
     * 左子树的右节点要和右子树的左节点相等。
     */
    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return check(left.left, right.right)
                && check(left.right, right.left);
    }
}
