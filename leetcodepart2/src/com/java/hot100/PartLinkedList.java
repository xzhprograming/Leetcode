package com.java.hot100;

import com.java.utils.ListNode;

/**
 * @className: PartLinkedList
 * @description:
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置
 *
 * 解题思路：
 * 模拟：
 *我们只需维护两个链表 small 和 large 即可，small 链表按顺序存储所有小于 x 的节点，large 链表按顺序存储所有大于等于 x 的节点。遍历完原链表后，
 * 我们只要将 small 链表尾节点指向 large 链表的头节点即能完成对链表的分隔。
 *
 * @author: xingzihao
 * @date: 2021/10/18
 **/
public class PartLinkedList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            } else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
