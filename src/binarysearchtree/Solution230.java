package binarysearchtree;


import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author xingzihao
 * @description
 * 230. 二叉搜索树中第 K 小的元素
 *
 * 思路：
 * way1:利用中序遍历，找到第k小个元素
 *
 *
 *
 *
 * way2:统计每个节点的子树节点树，并在查找第 k 小的值时，使用如下方法搜索：
 * 令 node 等于根结点，开始搜索。
 *
 * 对当前结点 node 进行如下操作：
 * 如果 node 的左子树的结点数 left 小于 k−1，则第 k 小的元素一定在 node 的右子树中，令 node 等于其的右子结点，k 等于 k−left−1(特别注意)，并继续搜索；
 * 如果 node 的左子树的结点数 left 等于 k−1，则第 k 小的元素即为 node ，结束搜索并返回 node 即可；
 * 如果 node 的左子树的结点数 left 大于 k−1，则第 k 小的元素一定在 node 的左子树中，令 node 等于其左子结点，并继续搜索。
 * 实现上，既可以将以每个结点为根结点的子树的结点数存储在结点中，也可以将其记录在哈希表中。
 *
 * @create 2025-03-02 11:20
 **/
public class Solution230 {

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }


    public int kthSmallest1(TreeNode root, int k) {
        Map<TreeNode, Integer> countMap = new HashMap<>();
        // 统计节点数量
        getCount(root, countMap);

        TreeNode node = root;
        while(node != null){
            int leftSize = countMap.getOrDefault(node.left, 0);
            if(leftSize == k - 1){
                return node.val;
            } else if(leftSize > k - 1){
                node = node.left;
            } else {
                node = node.right;
                k = k - leftSize - 1;
            }
        }
        return 0;
    }

    // 记录每个子树拥有的节点数量
    public int getCount(TreeNode node, Map<TreeNode, Integer> countMap){
        if(node == null){
            return 0;
        }

         int left = getCount(node.left,countMap);
         int right = getCount(node.right, countMap);
         countMap.put(node, 1 + left + right);
         return 1 + left + right;
    }
}
