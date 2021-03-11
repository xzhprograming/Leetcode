package com.java.binarysearchtree;

import com.java.utils.TreeNode;

/**
 * 题目：
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xing
 * @create 2021-03-11 14:25
 */
public class InsertInBST {
    private static class Solution {
        //Solution1：根据二叉树的有序性，对其节点值比较大小得到对应的插入位置，迭代法
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode pos = root;
            TreeNode target = new TreeNode(val);
            //边界条件
            if(root == null){
                return  target;
            }

            //插入过程
            while(pos != null){
                if(pos.val > val){ //若根节点的值大于给定的值，则插入其左子树中
                    if(pos.left == null){
                        pos.left = target;
                        break;  // 插入成功，退出
                    }
                    else
                        pos = pos.left;
                }
                else{  //若根节点的值大于给定的值，则插入其右子树中
                    if(pos.right == null){
                        pos.right = target;
                        break;
                    }
                    else
                        pos = pos.right;
                }
            }
            return root;
        }
        //Solution2：递归
        public TreeNode insertIntoBST1(TreeNode root, int val){
            //边界条件:即找到插入位置
            if (root == null)
                return new TreeNode(val);
            if (root.val < val)
                root.right = insertIntoBST(root.right, val);
            else if (root.val > val)
                root.left = insertIntoBST(root.left, val);
            return root;
        }
    }
}


