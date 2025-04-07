package common;

import binarytree.construct.Solution105;
import binarytree.traversetree.TraverseTree;

import java.util.List;

/**
 * @author xingzihao
 * @description
 * @create 2025-02-20 23:29
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode constructTree(int[] preOrder, int[] inOrder) {
        Solution105 solution105 = new Solution105();
        return solution105.buildTree(preOrder, inOrder);
    }

    public static List<Integer> traverseTree(TreeNode node){
        return TraverseTree.preorderTraversal(node);
    }
}
