package binarytree.thought;


import common.TreeNode;

/**
 * @author xingzihao
 * @description
 *
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 思路：
 * 分解问题：
 * 对于一个节点
 * 1、先利用 flatten(x.left) 和 flatten(x.right) 将 x 的左右子树拉平。
 * 2、将 x 的右子树接到左子树下方，然后将整个左子树作为右子树。
 *
 * 如何拉平？
 * 对于一个节点，需要将
 * node.left = null;
 * node.right = left;
 * 拉平后，还要考虑到right长度可能拼接了很长，需要找到最后一个right节点，并连接到node.right上
 *
 * 而且必须通过后序遍历的方式，因为需要从下至上做拉平操作才可以
 *
 * PS:
 * 二叉树解题的思维模式分两类：
 * 1、是否可以通过遍历一遍二叉树得到答案？如果可以，用一个 traverse 函数配合外部变量来实现，这叫「遍历」的思维模式。
 * 2、是否可以定义一个递归函数，通过子问题（子树）的答案推导出原问题的答案？如果可以，写出这个递归函数的定义，并充分利用这个函数的返回值，这叫「分解问题」的思维模式。
 * 无论使用哪种思维模式，都需要思考：
 * 如果单独抽出一个二叉树节点，它需要做什么事情？需要在什么时候（前/中/后序位置）做？
 * 其他的节点不用你操心，递归函数会帮你在所有节点上执行相同的操作。
 *
 * @create 2025-02-20 23:29
 **/
public class Solution114 {
    public void flatten(TreeNode root) {
        traverse(root);
    }

    public void traverse(TreeNode node){

        if(node == null){
            return;
        }

        traverse(node.left);
        traverse(node.right);

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = null;
        node.right = left;

        TreeNode temp = node;
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = right;
    }
}
