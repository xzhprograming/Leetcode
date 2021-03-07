import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 给你二叉树的根结点 root ，请你将它展开为一个单链表：

 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 展开后的单链表应该与二叉树 先序遍历 顺序相同。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    //解题思路：将先序遍历的序列存入list，重新构建树的结构
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        // 特殊情况
        if (root == null)
            return;
        preOrder(root, list);
        //根据先序遍历序列重建树结构
        for(int i = 1; i < list.size(); i++){
            TreeNode prev = list.get(i - 1);
            TreeNode right = list.get(i);
            prev.left = null;
            prev.right = right;
        }
    }

    //先序遍历并不会改变root的指向
    public void preOrder(TreeNode root, List list){
        if(root != null){
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
}
