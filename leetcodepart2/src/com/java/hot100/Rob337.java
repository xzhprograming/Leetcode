package com.java.hot100;

import com.java.utils.TreeNode;
import java.util.*;
/**
 * @className: Rob337
 * @description:
 * 337. 打家劫舍 III
 * 解题思路：
 * 简化一下这个问题：一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中），
 * 问在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少。
 *用 f(o) 表示选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；
 * g(o) 表示不选择 o 节点的情况下，o节点的子树上被选择的节点的最大权值和；l 和 r 代表 o 的左右孩子。
 *
 * 当 o 被选中时，o 的左右孩子都不能被选中，故 o 被选中情况下子树上被选中点的最大权值和为 l 和 r 不被选中的最大权值和相加，
 * 即 f(o) = g(l) + g(r) + o.val
 * 当 o 不被选中时，o 的左右孩子可以被选中，也可以不被选中。对于 o 的某个具体的孩子 x，它对 o 的贡献是 x 被选中和不被选中情况下权值和的较大值。
 * 故 g(o) =max{f(l),g(l)}+max{f(r),g(r)}
 *
 * 后序遍历这棵二叉树，我们就可以得到每一个节点的 f 和 g
 * @author: xingzihao
 * @date: 2021/10/20
 **/
public class Rob337 {

}

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
class Rob337Solution1 {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();
    public int rob(TreeNode root) {
        postOrder(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);

        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }
}

// 优化
/**
 * 无论是 f(o) 还是 g(o)，他们最终的值只和 f(l)、g(l)、f(r)、g(r)有关，所以对于每个节点，
 * 我们只关心它的孩子节点们的 f和 g 是多少。我们可以设计一个结构，表示某个节点的 f 和 g 值，在每次递归返回的时候，
 * 都把这个点对应的 f 和 g 返回给上一级调用，这样可以省去哈希表的空间。
 *
 */
class Rob337Solution2 {
    public int rob(TreeNode root){
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        int selected = node.val + l[1] + r[1];
        int notselected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notselected};
    }
}
