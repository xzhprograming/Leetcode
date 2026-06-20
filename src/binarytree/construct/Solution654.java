package binarytree.construct;

import common.TreeNode;

/**
 * @author xingzihao
 * @description
 * 654. 最大二叉树
 * 根据数组递归构造最大二叉树：根节点为区间最大值，左右子树分别由最大值左右两侧的子数组构成。
 * @create 2026-06-20 21:10
 **/
public class Solution654 {
    /**
     * 构造整段数组对应的最大二叉树。
     *
     * @param nums 不含重复元素的整数数组
     * @return 最大二叉树根节点
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    /**
     * 在闭区间 [start, end] 中寻找最大值作为当前根节点，
     * 再递归构造左右子树。
     */
    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int index = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] > nums[index]){
                index = i;
            }
        }

        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTree(nums, start, index - 1);
        node.right = constructMaximumBinaryTree(nums, index + 1, end);
        return node;
    }
}
