package com.java.binarytree;

import com.java.utils.TreeNode;

import java.util.HashMap;
/**
 * @author xing
 * @create 2021-03-08 23:02
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    int rightsize = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd){
        //特殊情况
        if(iStart > iEnd || pStart > pEnd){
            return null;
        }


        //找到根节点所在的索引
        int index = iStart;
        for(int i = iEnd; i >= iStart; i--){
            if(inorder[i] == postorder[pEnd]){
                index = i;
                break;
            }
        }
        //获取当前所需构建的右子树长度
        int rightsize = iEnd - index;

        //构建根节点
        TreeNode root = new TreeNode(inorder[index]);
        root.right = build(inorder, index + 1, iEnd, postorder, pEnd - rightsize, pEnd - 1);
        //构建左子树时还需减去右子树的长度
        root.left = build(inorder, iStart, index - 1, postorder, pStart, pEnd - rightsize - 1);
        return root;
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(Integer.toString(a));
        String b = a + ",";
        System.out.println(b);
        HashMap<String, Integer> map = new HashMap<>();
        int freq = map.getOrDefault("a", 0);
        map.put("a", 1);
        if (freq == 0){

        }
    }
}
