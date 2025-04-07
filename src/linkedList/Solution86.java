package linkedList;

import common.ListNode;

/**
 * @author xingzihao
 * @description
 * 86. 分隔链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 思路：遍历链表，将小于x的节点放在一个链表中，将大于等于x的节点放在另一个链表中，然后将两个链表连接起来。
 * @create 2025-03-19 23:46
 **/
public class Solution86 {

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
