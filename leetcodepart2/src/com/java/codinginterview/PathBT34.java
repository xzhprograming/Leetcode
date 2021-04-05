package com.java.codinginterview;

import com.java.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *面试题34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 注意：要求根节点到叶节点
 * @author xing
 * @create 2021-04-05 14:21
 */
public class PathBT34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        dfs(root, ans, temp, target);
        return ans;
    }

    public void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> temp, int target){
        if(root == null)
            return;
        temp.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null){
            ans.add(new LinkedList(temp));
        }

        dfs(root.left, ans, temp, target);
        dfs(root.right, ans, temp, target);
        temp.remove(temp.size() - 1);
    }
}
