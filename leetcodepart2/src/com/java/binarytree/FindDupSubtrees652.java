package com.java.binarytree;

import com.java.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 解题思路：
 * 1.使用二叉树的后序遍历，得到完整的子树
 * 2.子树的结构可用后序遍历字符串String表示
 * String subTree = left + "," + right + "," + root.val;
 *  注：这里使用双引号代表String的拼接操作，使用单引号会被认为是字符，无法拼接报错
 *  或者使用
 *  String subTree = Integer.toString(left) + Integer.toString(right) + Integer.toString(root.val);
 * 可类比的题目：求二叉树的总节点数
 *
 * @author xing
 * @create 2021-03-09 21:16
 */
public class FindDupSubtrees652 {
    List<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }
    //后序遍历
    public String traverse(TreeNode root){
        //特殊情况：为空时使用#代替其所在位置
        if(root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        //TODO
        //将树的结构序列化，便于比较
        String subTree = left + "," + right + "," + root.val;
        //设置子树出现的次数
        int count = map.getOrDefault(subTree, 0);
        //只会添加一次
        if(count == 1){
            res.add(root);
        }
        map.put(subTree, count + 1);
        return subTree;
    }

    // 计算二叉树的总节点数
    public int countNode(TreeNode root){
        //特殊情况：节点为空时，节点数为0
        if (root == null){
            return 0;
        }
        //递归求左右子树节点数
        int left = countNode(root.left);
        int right = countNode(root.right);
        //总结点个数 = 左子树节点 + 右子树节点 + 自身节点
        int res = left + right + 1;
        return res;
    }

    public static void main(String[] args) {
        FindDupSubtrees652 f  = new FindDupSubtrees652();
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,4,null,2,4,null,null,4]");
        f.findDuplicateSubtrees(root);
        System.out.println(f.countNode(root));
    }
}


