package binarytree.traversetree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author xingzihao
 * @description
 * @create 2025-03-02 11:36
 **/
public class TraverseTree {

    //------------------------------------------递归遍历------------------------------------------

    /**
     * 先序遍历
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }


    /**
     * 后序遍历
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    //------------------------------------------迭代法遍历------------------------------------------


    /**
     * 先序遍历
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            // 先访问根节点
            list.add(root.val);
            // 注意：先压入右子节点，再压入左子节点，因为栈是后进先出
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // 先访问左子树
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            // 到左子树的尽头了，弹出栈顶元素并访问它
            current = stack.pop();
            list.add(current.val);
            // 转向右子树
            current = current.right;
        }
        return list;
    }

    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        // 回溯到根节点，右子树不为空，则根节点继续入栈，且开始遍历右子树
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        // 记录前一个节点，向上回溯的过程中可能该节点已经被遍历过
        TreeNode prev = null;
        while(!stack.isEmpty() || current != null){
            // 一直遍历到最左节点
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            // 如果该节点右子树为null, 或者右子树节点为遍历过的节点，则可以将值添加到list，并重置prev和current
            if(current.right == null || current.right == prev){
                list.add(current.val);
                // 将当前节点置为prev
                prev = current;
                // 表明当前子树已经遍历完成，可以继续从栈中取节点遍历
                current = null;
            } else {
                // 不为空则再次将节点入栈，继续遍历右子树
                stack.push(current);
                current = current.right;
            }
        }
        return list;
    }

    /**
     * 后序遍历：双栈法
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        // 第一个栈用于存储节点
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            // Stack2 的入栈顺序是 根 -> 右 -> 左
            stack2.push(node);

            // 如果左子节点存在，压入第一个栈
            if (node.left != null) {
                stack1.push(node.left);
            }

            // 如果右子节点存在，压入第一个栈
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        // 从第二个栈中弹出节点并添加到结果列表中
        // 弹出 Stack2 时，顺序是 左 -> 右 -> 根，即后序遍历的正确顺序。
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }


    public static List<Integer> traverse1(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            // 左节点入栈
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            // 出栈
            TreeNode tmp = stack.pop();
            ans.add(tmp.val);

            root = tmp.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{1,2,4,5,3};
        int[] inOrOrder = new int[]{4,2,5,1,3};
        TreeNode treeNode = TreeNode.constructTree(preOrder, inOrOrder);
        System.out.println(TraverseTree.traverse1(treeNode));
    }
}

