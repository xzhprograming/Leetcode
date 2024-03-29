import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * @author xing
 * @create 2021-03-07 15:13
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    // solution1:递归实现
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //特殊情况：若根节点为null，或者p或q其中一个节点为根节点时
        if(root == null || p == root || q == root)
            return root;
        //后序遍历二叉树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况1：left和right一定分别是p和q
        // 当 left 和 right 同时为空 ：说明 root 的左右子树中都不包含 p,q ，返回 null
        if(left == null && right == null)
            return null;
        //情况2
        // 当 left 和 right 同时不为空 ：说明 p, q 分列在 root 的异侧（分别在左右子树），因此 root 为最近公共祖先，返回root ；
        if(left != null && right != null)
            return root;
        //情况3
        // 当 left为空 ，right 不为空 ：p,q 都不在 root的左子树中，直接返回right。否则返回left
        return left == null ? right : left;
    }

    // solution2:后序遍历存储所有的父节点，使用set存储p的父节点的值，如果set包含q的父节点，那此节点就是最近公共祖先
    Map<Integer, TreeNode> map = new HashMap<>(); // 存储所有的父节点
    Set<Integer> set = new HashSet<>(); //存储p的父节点
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //特殊情况：根节点为空的情况
        if (root == null)
            return null;

        dfs(root);

        while (p != null){
            set.add(p.val);  // 先存储p的值，因为最近公共祖先有可能是其本身
            p = map.get(p.val); //获取p的父节点
        }

        while (q != null){
            // 若set中包含q或其父节点，则return q，否则继续遍历q的父节点
            if (set.contains(q.val))
                return q;
            q = map.get(q.val);
        }

        return null;
    }

    // 除根节点外，其余节点存入HashMap中
    public void dfs(TreeNode root){
        if (root.left != null){
            map.put(root.left.val, root); //添加的为其父节点
            dfs(root.left);
        }
        if (root.right != null){
            map.put(root.right.val, root);
            dfs(root.right);
        }
        System.out.println(root.val);
    }
}
