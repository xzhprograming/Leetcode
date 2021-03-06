package com.java.binarytree;
import com.java.utils.TreeNode;
/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 例如，输入为
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 解题思路：
 * 根据前序遍历找到根节点，中序遍历序列根据根节点将区间划分为左右子树，
 * 构建根节点，同时构左右节点
 * @author xing
 * @create 2021-03-08 22:20
 */


public class ConstructBTree105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 划分左右子树进行左右子树构建
        int leftSize = index - inStart;  // 获取当前左子树的长度

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        // 构建右子树这里传入的起始点应为pstart + leftsize + 1
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
