package binarytree.construct;

import common.TreeNode;

import java.util.Stack;

/**
 * @author xingzihao
 * @description
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 思路:
 * 1. 递归
 * preorder顺序为（root,left,right）
 * inorder顺序为（left, root, right）
 * 可以利用preorder定位inorder中的根节点，划分为左子树和右子树，然后再递归构建左子树和右子树
 * 注意：
 * inorder划分的索引为左子树（start， index-1）,右子树（index + 1, end）
 * leftsize = index - start, 即inorder划分的左子树的长度
 * preorder划分的索引为左子树（pstart + 1， pstart + leftSize）,右子树（pstart + leftsize + 1, pend）
 * 2. 迭代
 * 按照前序遍历来构建二叉树 中序遍历应该是用来定位根节点
 * 对于前序遍历中的任意两个连续节点u和v，根据前序遍历的流程，我们可以知道u和v只有两种可能的关系：
 *
 * v是u的左儿子。这是因为在遍历到u之后，下一个遍历的节点就是u的左儿子，即v；
 *
 * u没有左儿子，并且v是u的某个祖先节点（或者u本身）的右儿子。如果u没有左儿子，那么下一个遍历的节点就是u的右儿子。
 * 如果u没有右儿子，我们就会向上回溯，直到遇到第一个有右儿子（且u不在它的右儿子的子树中）的节点u
 *
 * 利用栈依次将先序序列入栈，并同时与inorder[index]作比较，直到找到栈顶元素与inorder[index]相等的元素，然后再回溯构建右儿子
 * 总体来讲就是，先构建左儿子，直到遇到一个非左儿子的节点，回溯找到该右儿子节点的所在位置（即向上回溯的第一个栈顶和inorder[index]不相等的节点）。
 *
 * @create 2025-02-23 10:56
 **/
public class Solution105 {
    /**
     * 递归方法
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 利用先序遍历序列，将inorder顺序分离为(left,root,right),再分别构建根节点，左节点、右节点
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int start, int end){
        if(pStart > pEnd || start > end){
            return null;
        }
        // 找到root节点，root 节点对应的值就是前序遍历数组的第一个元素
        int index = start;
        for(int j = index; j <= end; j++){
            if(inorder[j] == preorder[pStart]){
                index = j;
                break;
            }
        }
        int leftsize = index - start;

        // 构建root、left、right节点
        TreeNode root = new TreeNode(inorder[index]);
        // 递归构造左右子树
        root.left = buildTree(preorder, pStart + 1, pStart + leftsize, inorder, start, index - 1);
        root.right = buildTree(preorder, pStart + leftsize + 1, pEnd, inorder, index + 1, end);
        return root;
    }


    /**
     * 迭代法
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 利用前序遍历序列TLR, 中序LTR
        // 按照前序遍历来构建二叉树 中序遍历应该是用来定位根节点的

        Stack<TreeNode> stack = new Stack<>();

        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        int index = 0;
        for(int i = 1; i < preorder.length; i++){
            TreeNode topNode = stack.peek();
            TreeNode node = new TreeNode(preorder[i]);
            if(topNode.val != inorder[index]){
                topNode.left = node;
                stack.push(node);
            } else {
                while(!stack.isEmpty() && stack.peek().val == inorder[index]){
                    topNode = stack.pop();
                    index++;
                }
                topNode.right = node;
                stack.push(node);
            }
        }

        return root;

    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution105 solution105 = new Solution105();
        TreeNode root = solution105.buildTree1(preorder, inorder);
        System.out.println(root.val);
    }

}
