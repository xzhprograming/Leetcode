package binarysearchtree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xingzihao
 * @description 95. 不同的二叉搜索树 II
 *
 * 给定整数 n，生成并返回所有由 1 到 n 组成的不同二叉搜索树。
 *
 * 思路：
 * 枚举 [start, end] 中的每个值作为根节点，递归生成所有可能的左子树和右子树，
 * 再将左右子树两两组合到当前根节点上。
 * @create 2026-06-21 23:53
 **/
public class Solution95 {
    /**
     * 生成由 1 到 n 组成的所有不同 BST。
     *
     * @param n 节点值范围上界
     * @return 所有结构不同的二叉搜索树根节点
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> allTree = new LinkedList<>();
        if (n == 0) {
            return allTree;
        }
        return generateTrees(1, n);
    }

    /**
     * 生成由闭区间 [start, end] 内所有值组成的不同 BST。
     */
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTree = new LinkedList<>();

        // 空区间表示空子树，需要用 null 参与后续左右子树组合。
        if (start > end) {
            allTree.add(null);
            return allTree;
        }

        for (int i = start; i <= end; i++) {
            // BST 左子树的值都小于根节点，右子树的值都大于根节点。
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);

            // 固定根节点 i 后，所有左子树和右子树的组合都是合法且互不相同的 BST。
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    allTree.add(root);
                }
            }
        }
        return allTree;
    }
}
