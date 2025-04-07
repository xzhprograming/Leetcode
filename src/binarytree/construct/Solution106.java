package binarytree.construct;

import common.TreeNode;
/**
 * @author xingzihao
 * @description
 * 106. 从中序与后序遍历序列构造二叉树
 *  给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 * @create 2025-02-23 14:40
 **/
public class Solution106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 中序LTR, 后序LRT
        // 利用后序序列定位根节点位置，拆分中序序列为（left, root, right）再递归构造左子树，右子树
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd){
        if(iStart > iEnd || pStart > pEnd){
            return null;
        }
        int rootIndex = pEnd;
        for(int i = iStart; i <= iEnd; i++){
            if(inorder[i] == postorder[pEnd]){
                rootIndex = i;
                break;
            }
        }
        int rightSize = iEnd - rootIndex;

        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left =  buildTree(inorder, iStart, rootIndex - 1, postorder, pStart, pEnd - rightSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, iEnd, postorder, pEnd - rightSize, pEnd - 1);
        return root;
    }
}
