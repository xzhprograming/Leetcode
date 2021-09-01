package com.java.codinginterview;


import java.util.*;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * 拷贝普通链表：如果是普通链表，我们可以直接按照遍历的顺序创建链表节点。
 * 因为随机指针的存在，当我们拷贝节点时，「当前节点的随机指针指向的节点」可能还没创建
 *
 * 注： 综上所述，我们应该先将新的节点构造出来
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class copyRandomList35 {
    //    方法1：哈希法存储原节点与新节点的对应关系
    public Node copyRandomList1(Node head) {
        // 复制节点,同时保存原节点与新节点的对应关系
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 构建新链表的 next 和 random 指向
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新链表的头节点
        return map.get(head);
    }

    // 方法二：拼接 + 拆分
    public Node copyRandomList2(Node head) {
        // 拼接 + 拆分
        if(head == null){
            return null;
        }

        // 1.复制各节点，并构建拼接链表
        Node cur = head;
        while(cur != null){
            Node newNode = new Node(cur.val);
            Node nextNode = cur.next;
            cur.next = newNode;
            newNode.next = nextNode;
            cur = nextNode;
        }

        // 2.构建各新节点的 random 指向
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //  3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        // 单独处理原链表尾节点
        pre.next = null;
        return res;
    }
}
