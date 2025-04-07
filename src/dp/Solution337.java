package dp;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingzihao
 * @description
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 *
 * 思路：
 * 1. 自底向上递推
 * 2. f(o) 表示选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；
 * g(o) 表示不选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；l 和 r 代表 o 的左右孩子。
 *
 * 当 o 被选中时，o 的左右孩子都不能被选中，故 o 被选中情况下子树上被选中点的最大权值和为 l 和 r 不被选中的最大权值和相加，
 * 即 f(o)=g(l)+g(r)。
 * 当 o 不被选中时，o 的左右孩子可以被选中，也可以不被选中。对于 o 的某个具体的孩子 x，它对 o 的贡献是 x 被选中和不被选中情况下权值和的较大值。
 * 故 g(o)=max{f(l),g(l)}+max{f(r),g(r)}。
 *
 * @create 2025-03-15 14:27
 **/
public class Solution337 {

    // 小技巧：树形结构不像斐波那契数列这种题型一样，可以用数组来做备忘录缓存，可以改用哈希表来存储
    // 选中当前节点R，对应的最大权值和
    Map<TreeNode, Integer> f = new HashMap<>();
    // 不选中当前节点R，对应的最大权值和
    Map<TreeNode, Integer> g = new HashMap<>();
    public int rob(TreeNode root) {
        traverse(root);
        // 比较根节点选中和不被选中时权值和， 返回最大值
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        traverse(root.right);
        // 自底向上递推
        // 选中当前节点，则其左右子节点都不能被选中
        f.put(root, root.val + g.getOrDefault(root.left, 0) +  g.getOrDefault(root.right, 0));
        // 不选中当前节点，则其权重和为左右子节点的和
        int left = Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0));
        int right = Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0));
        g.put(root, left + right);
    }


    /**
     * 树形DP优化解法
     * @param root
     * @return
     */
    public int rob1(TreeNode root) {
        int[] arr = dfs(root);
        return Math.max(arr[0], arr[1]);
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0 , 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int selected = root.val + left[1] + right[1];

        int unSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{selected, unSelected};
    }
}
