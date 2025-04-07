package binarytree.thought;

import common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingzihao
 * @description
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 *
 * 输入：root = []
 * 输出：[]
 *
 * 思路1：迭代法
 * 使用BFS遍历每一层的节点，并且设置其next指针的值
 *
 * 思路2：递归
 * 对于非同一个父节点：将left.right 和 right.left相连
 * 对于同一个父节点： 将left和right节点连接
 *
 * @create 2025-02-20 22:31
 **/
public class Solution116 {

    // 迭代法
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                node.next = queue.peek();
                if(i == size - 1){
                    node.next = null;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node. right);
                }
            }
        }
        return root;
    }

    // 递归解法
    public Node connect2(Node root) {
        dfs(root);
        return root;
    }

    public void dfs(Node node){
        if(node == null){
            return;
        }


        Node left = node.left;
        Node right = node.right;

        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }

        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }
}
