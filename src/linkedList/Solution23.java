package linkedList;

import common.ListNode;

/**
 * @author xingzihao
 * @description
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 思路：
 * 遍历每一个链表，依次合并
 * @create 2025-03-20 22:28
 **/
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode ans = lists[0];
        for(int i = 1; i < lists.length; i++){
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;

    }


    /**
     * 分治思想
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);

    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start > end){
            return null;
        }

        if(start == end){
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
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
}
