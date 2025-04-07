package binarytree.serialize;

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xingzihao
 * @description
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 思路：
 * DFS：利用递归进行序列化和反序列化
 *
 * BFS：利用层序遍历思想，结合队列完成序列化和反序列化
 *
 * @create 2025-02-23 20:48
 **/
public class Solution296 {

    /**
     * BFS
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node == null){
                    sb.append("#,");
                } else{
                    sb.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while(index < array.length && !queue.isEmpty()){
            TreeNode node = queue.poll();

            if(!array[index].equals("#")){
                node.left = new TreeNode(Integer.valueOf(array[index]));
                queue.offer(node.left);
            }
            index++;
            if(index < array.length && !array[index].equals("#")){
                node.right = new TreeNode(Integer.valueOf(array[index]));
                queue.offer(node.right);
            }
            index++;
        }

        return root;
    }


    /**
     * 前序遍历
     */
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if(root == null){
            return "";
        }
        traverse(root);
        return sb.toString();
    }

    /**
     * 生成前序遍历字符串
     * @param root
     * @return
     */
    public String serialize2(TreeNode root, String str) {
        if(root == null){
            str += "#,";
            return str;
        }
        str += root.val + ",";
        str = serialize2(root.left, str);
        str = serialize2(root.right, str);
        return str;
    }

    public void traverse(TreeNode root){
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        traverse(root.left);
        traverse(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));

        return buildTree(list);
    }

    public TreeNode buildTree(List<String> list){
        String val = list.remove(0);
        if(val.equals("#")){
            return null;
        }

        int rootVal = Integer.valueOf(val);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(list);
        root.right = buildTree(list);
        return root;
    }


    /**
     * 后序遍历
     */
    StringBuilder sb3 = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize4(TreeNode root) {
        return serialize3(root, "");
    }

    /**
     * 生成后序遍历字符串
     * @param root
     * @return
     */
    public String serialize3(TreeNode root, String str) {
        if(root == null){
            str += "#,";
            return str;
        }
        str = serialize2(root.left, str);
        str = serialize2(root.right, str);
        str += root.val + ",";
        return str;
    }

    public void traverse3(TreeNode root){
        if(root == null){
            sb.append("#,");
            return;
        }
        traverse(root.left);
        traverse(root.right);
        sb.append(root.val + ",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize3(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));

        return buildTree3(list);
    }

    public TreeNode buildTree3(List<String> list){
        String val = list.remove(list.size() - 1);
        if(val.equals("#")){
            return null;
        }

        int rootVal = Integer.valueOf(val);
        TreeNode root = new TreeNode(rootVal);
        root.right = buildTree(list);
        root.left = buildTree(list);
        return root;
    }

    public static void main(String[] args) {
        String s = "1,2,3,#,#,4,5,";
        Solution296 solution = new Solution296();
        TreeNode root = solution.deserialize(s);
        System.out.println(solution.serialize(root));
    }
}
