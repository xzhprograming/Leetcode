package binarytree.construct;

import common.TreeNode;

import java.util.HashMap;

/**
 * @author xingzihao
 * @description
 * 889. 根据前序和后序遍历构造二叉树
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 *
 * 如果存在多个答案，您可以返回其中 任何 一个。
 *
 *
 * 思路：
 * 根据前序遍历与后序遍历的定义，preorder[0]与postorder[n−1]都对应二叉树的根节点。获取根节点后，我们需要划分根节点的左子树与右子树，考虑两种情况：
 * 原二叉树的根节点的左子树不为空，那么preorder[1]对应左子树的根节点；
 * 原二叉树的根节点的左子树为空，那么preorder[1]对应右子树的根节点。
 *
 * 基于第一种思想，将preorder划分为根节点、左子树节点和右子树节点三个部分，postorder也划分为左子树节点、右子树节点和根节点三个部分，同时当节点数目为1时，对应构造的二叉树只有一个节点。
 * 可以递归构造二叉树。
 *
 * 1、首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值。
 * 2、然后把前序遍历结果的第二个元素作为左子树的根节点的值。
 * 3、在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可。
 *
 * @create 2025-02-23 15:06
 **/
public class Solution889 {

    class Solution {
        // 存储 postorder 中值到索引的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                valToIndex.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        // 定义：根据 preorder[preStart..preEnd] 和 postorder[postStart..postEnd]
        // 构建二叉树，并返回根节点。
        TreeNode build(int[] preorder, int preStart, int preEnd,
                       int[] postorder, int postStart, int postEnd) {
            if (preStart > preEnd) {
                return null;
            }
            if (preStart == preEnd) {
                return new TreeNode(preorder[preStart]);
            }

            // root 节点对应的值就是前序遍历数组的第一个元素
            int rootVal = preorder[preStart];
            // root.left 的值是前序遍历第二个元素
            // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
            // 确定 preorder 和 postorder 中左右子树的元素区间
            int leftRootVal = preorder[preStart + 1];
            // leftRootVal 在后序遍历数组中的索引
            int index = valToIndex.get(leftRootVal);
            // 左子树的元素个数
            int leftSize = index - postStart + 1;

            // 先构造出当前根节点
            TreeNode root = new TreeNode(rootVal);
            // 递归构造左右子树
            // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
            root.left = build(preorder, preStart + 1, preStart + leftSize,
                    postorder, postStart, index);
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                    postorder, index + 1, postEnd - 1);

            return root;
        }
    }
}
