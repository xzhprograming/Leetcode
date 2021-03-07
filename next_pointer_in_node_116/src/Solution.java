import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给定一个完全二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 *输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xing
 * @create 2021-03-07 20:28
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class Solution {
    //solution1：层次遍历BFS
    public Node connect(Node root) {
        // BFS
        //特殊情况
        if (root == null)
            return null;
        Node rootCopy = root;
        Queue<Node> qu = new LinkedList<>();
        //1.添加第一个节点
        qu.offer(rootCopy);

        //层次遍历二叉树，将每一层添加进入队列
        while(!qu.isEmpty()){
            int sz = qu.size();
            for(int i = 0; i < sz; i++){
                Node tmpNode = qu.poll();

                //TODO
                Node nextNode;
                if(i != sz - 1)
                    nextNode = qu.peek();
                else  // 当移动到此层的最后一个元素的时候，将其next置为null
                    nextNode = null;

                tmpNode.next = nextNode;

                if(tmpNode.left != null){
                    qu.offer(tmpNode.left);
                }
                if(tmpNode.right != null){
                    qu.offer(tmpNode.right);
                }
            }
        }
        return root;
    }

    //Solution2: 递归遍历DFS
    public Node connect1(Node root) {
        // 因为需要连接跨越父节点的两个节点，所以应该扩展此函数参数，改为连接两个节点
        if (root != null)
            connectTwoNode(root.left, root.right);
        return root;
    }
    public void connectTwoNode(Node node1, Node node2){
        if (node1 == null || node2 == null){ //如果左右节点有一个为空，则不需要连接
            return;
        }

        node1.next = node2; // 连接操作

        //连接同一个父节点的左右子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        //连接非同一个父节点的左右相邻子节点
        connectTwoNode(node1.right, node2.left);
        //关于遍历到每一层之后的null节点，不连接next，自然每一层后面的next节点默认就是null了
    }
}
