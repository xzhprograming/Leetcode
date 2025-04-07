package binarytree;

import common.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xingzihao
 * @description
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 思路：
 * way1:
 * 既在左子树找p和q，又在右子树找p和q。
 * 只要找到p或q的其中一个就可以返回，如果left和right都不为空，说明左右子树各找到p和q当中的一个，那么p和q在root的两侧。
 * 如果left不为空，说明p,q在左子树。
 * 如果right不为空，说明p,q在右子树。
 * left和right都为空，说明找不到。
 *
 * way2:
 * 记录下所有节点的父节点，从p或q出发，向上访问，直到出现交集节点
 *
 * @create 2025-02-24 22:33
 **/
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当遇到叶子节点或 节点 p 或 q 时返回
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 当节点 p,q 在节点 root 的异侧时，节点 root 即为最近公共祖先，则向上返回 root
        if(left != null && right != null){
            return root;
            // 当p、q在右子树找到时，返回right
        } else if(left == null){
            return right;
            // 当p、q在左子树找到时，返回left
        } else if(right == null){
            return left;
        } else{
            return null;
        }
    }


    /**
     * 从p或q出发，向上访问，直到出现交集节点
     */
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root);
        // 找到p的所有祖先
        Set<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = map.get(p);
        }

        // 再依次找q的祖先，如果p的祖先包含q或它的祖先，那么遍历到的当前节点即为最近的公共祖先节点
        while(q != null){
            if(set.contains(q)){
                return q;
            }
            q = map.get(q);
        }
        return null;
    }


    //记录下所有节点的父节点
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            map.put(root.left, root);
            traverse(root.left);
        }
        if(root.right != null){
            map.put(root.right, root);
            traverse(root.right);
        }
    }
}
