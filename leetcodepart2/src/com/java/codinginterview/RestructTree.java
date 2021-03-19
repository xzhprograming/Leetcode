package com.java.codinginterview;

import com.java.utils.TreeNode;

/**
 * @author xing
 * @create 2021-03-19 22:00
 */
public class RestructTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int plen = preorder.length;
        int ilen = inorder.length;
        return build(preorder, 0, plen - 1, inorder, 0 ,ilen - 1);
    }

    // 记录左子树和右子树划分的下标
    // 递归进行构建
    public TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend){
        // 边界条件
        if(pstart > pend || istart > iend)
            return null;
        int index = istart;

        // 从中序遍历序列中找到根节点
        for(; index <= iend; index++){
            if(inorder[index] == preorder[pstart]){
                break;
            }
        }
        // 划分左右子树进行左右子树构建
        int leftsize = index - istart;
        // 创建当前根节点
        TreeNode root = new TreeNode(preorder[pstart]);
        root.left = build(preorder, pstart + 1, pstart + leftsize, inorder, istart, index - 1);
        root.right = build(preorder, pstart + leftsize + 1, pend, inorder, index + 1, iend);
        return root;
    }
}
