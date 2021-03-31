package com.java.codinginterview;

import com.java.utils.TreeNode;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author xing
 * @create 2021-03-31 17:36
 */
public class SequenceTree {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        List<String> list = Arrays.asList(s);
        Queue<String> queue = new LinkedList<>(list);
        TreeNode ans = dfs(queue);
        return ans;
    }

    public TreeNode dfs(Queue<String> queue){
        if (queue.isEmpty())
            return null;
        String temp = queue.poll();
        if (temp.equals("null")){
            return null;
        }
        int val = Integer.parseInt(temp);
        TreeNode newNode = new TreeNode(val);
        newNode.left = dfs(queue);
        newNode.right = dfs(queue);
        return newNode;
    }

    public void preOrder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public static void test1(){
        StringBuilder sb = new StringBuilder();
        test(10, sb);
        System.out.println(sb.toString());
    }
    public static void test(int n, StringBuilder sb){
        if (n == 0)
            return;
        test(n - 1, sb);
        sb.append(n);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        SequenceTree st = new SequenceTree();
        TreeNode node = TreeNode.stringToTreeNode("[1,2,3,null,null,4,5]");
        System.out.println(TreeNode.treeNodeToString(node));
        String ans = st.serialize(node);
        System.out.println(ans);
    }
}
