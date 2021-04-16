package com.java.binarytree;

import java.util.*;

/**
 * 非递归方式后续遍历
 *
 * <p>
 * <p>
 * 我们尝试想一下如果用递归的方式来实现这个逻辑应该是怎么样的流程，代码应该是这样的
 * if node == null
 * return;
 * postorderTraversal(node.left);
 * postorderTraversal(node.right);
 * list.add(node.val)
 *
 * <p>
 * <p>
 * 那我们用递归来实现这段代码，整体上来说整体上来说，就是用一个栈来模拟递归的调用栈
 * 首先我们肯定是通过某种方式来迭代数据，思考下代码的终止条件，应该不难想到  node != null || !stack.isEmpty()
 * 只有node和stack的同时都没有数据时，递归才应该停下来
 * 随后我们想一下如果node != null时，按照之前迭代版本的代码，他总是会先递归处理node.left，这就可以看作将当前node推入栈，
 * node = node.left
 * 同时如果node == null, 在递归版本的代码里面，操作是return，会返回上一层的递归调用，这就类似于将我们的栈中栈顶元素弹出来，
 * 不过这里有一个细节需要注意，如果右边此时存在可以迭代的元素，我们还是要将当前元素推入栈中，并且node=node.right，反之说明
 * 右边不存在可以迭代的元素了，处理当前节点即可。
 *
 * <p>
 * <p>
 * 我们采用了node.right == null || node.right == prev来判断右边是否不存在元素可以迭代，这里有两个场景需要考虑，一个是
 * 右边确实没有元素了，还有一个是右边的元素已经迭代过了，第二个场景比较特殊，我们说一下，比如
 * 1
 * \
 * 3
 * 按我们现有的逻辑，当处理完3时，此时会弹出栈当中的1，进行处理，但是如果没有node.right == prev这个判断，他会继续将3
 * 压入栈中，形成死循环，所以需要加上一个变量记录上一次造访过的节点是哪个，方便去重
 */
public class postorderTraversal {
    //递归版
    public List<TreeNode> postorderTraversal1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    private void dfs(List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(list, root.left);
        dfs(list, root.right);
        list.add(root);
    }


    //非递归版1（这种比较难理解）
    public List<TreeNode> postorderTraversal2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) { // 当栈顶元素的右子树为空或者已经遍历过
                list.add(root);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }



    //非递归版2（这种比较好理解）, 将前序遍历“中左右”的左右压栈顺序颠倒变成“中右左”，然后结果进行反转即可
    public List<TreeNode> postorderTraversal3(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            list.add(tmp);
            if(tmp.left!=null){ // 本来前序遍历的压栈顺序为先右后左，这里要相反，要先压左边的
                stack.push(tmp.left);
            }
            if(tmp.right!=null){
                stack.push(tmp.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
