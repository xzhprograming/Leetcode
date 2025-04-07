package linkedList;

import common.ListNode;

/**
 * @author xingzihao
 * @description
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @create 2025-03-20 22:21
 **/
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);

        ListNode node = dummy;

        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                node.next = list2;
                list2 = list2.next;
            } else{
                node.next = list1;
                list1 = list1.next;
            }
            node = node.next;
        }

        if(list1 != null){
            node.next = list1;
        }

        if(list2 != null){
            node.next = list2;
        }

        return dummy.next;

    }
}
