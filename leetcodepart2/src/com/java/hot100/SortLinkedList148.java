package com.java.hot100;

import com.java.utils.ListNode;

/**
 * 148. 排序链表
 *给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 *
 * 解题思路：
 * 时间复杂度是 O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)），其中最适合链表的排序算法是归并排序。
 * 1. 找到链表中点
 * 2. 递归终止条件：head.next=null
 * 3. 合并两个已排序链表
 * @author xing
 * @create 2021-05-23 23:17
 */
public class SortLinkedList148 {
    public ListNode sortList(ListNode head) {
        // 边界条件
        if(head == null || head.next == null)
            return head;

        //找中点
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 合并两个有序链表
        ListNode dummyNode = new ListNode(0);
        ListNode res = dummyNode;
        while(left != null && right != null){
            if(left.val < right.val){
                res.next = left;
                left = left.next;
            }
            else{
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = left != null ? left : right;
        return dummyNode.next;
    }
}
