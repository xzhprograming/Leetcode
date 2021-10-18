package com.java.hot100;

import com.java.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 148. 排序链表
 *给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 *
 * 解题思路：
 * 时间复杂度是 O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)），其中最适合链表的排序算法是归并排序。
 * 1. 找到链表中点,奇数个节点找到中点，偶数个节点找到中心左边的节点。
 *         ListNode slow = head;
 *         ListNode fast = head.next;
 * 2. 递归终止条件：head == null || head.next=null
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

    public static void main(String[] args) {
        SortLinkedListSolution2 solution2 = new SortLinkedListSolution2();
        int[] nums = new int[]{-1,5,3,4,0};
        List<Integer> list = new ArrayList<>();
        for (int num : nums){
            list.add(num);
        }
        ListNode listNode = new ListNode();
        ListNode node = listNode.constructlist(list);
        solution2.sortList(node);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}


// 快速排序链表:交换节点
class SortLinkedListSolution2{
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    public void quickSort(ListNode head, ListNode tail){
        if(head == tail){
            return;
        }
        int partition = head.val;
        ListNode left = head;
        ListNode cur = head.next;
        while(cur != tail){
            if(cur.val < partition){
                left = left.next;
                swap(left, cur);
            }
            cur = cur.next;
        }
        swap(head, left);
        quickSort(head, left);
        quickSort(left.next, tail);
    }

    public void swap(ListNode node1, ListNode node2){
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}

// 快速排序链表:
class SortLinkedListSolution3{
    public ListNode sortList(ListNode head) {
        return quickSort(head);
    }

    public ListNode quickSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        int partition = head.val;

        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        ListNode pre = head;
        while(pre != null){
            if(pre.val < partition){
                small.next = pre;
                small = small.next;
            } else{
                large.next = pre;
                large = large.next;
            }
            pre = pre.next;
        }
        large.next = null;
        small.next = largeHead.next;
        // 递归调用,注：先重排右边的,再把指针置空,再重排左边的
        // 和归并排序很像
        ListNode right = quickSort(head.next);
        head.next = null;
        ListNode left = quickSort(smallHead.next);
        // 拼接左半部分和右半部分
        pre = left;
        while(pre.next != null){
            pre = pre.next;
        }
        pre.next = right;
        return left;
    }
}