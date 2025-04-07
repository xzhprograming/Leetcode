package linkedList;

import common.ListNode;
/**
 * @author xingzihao
 * @description
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @create 2025-03-30 14:55
 **/
public class Solution148 {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 断键
        ListNode next = slow.next;
        slow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);

        return mergeTwoLists(left, right);
    }

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

    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{4, 2, 1, 3});
        Solution148 solution148 = new Solution148();
        ListNode listNode = solution148.mergeSort(head);
        System.out.println(listNode);
    }
}
