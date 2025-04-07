package linkedList;

import common.ListNode;

/**
 * @author xingzihao
 * @description
 * 25. K 个一组翻转链表 https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 思路：
 * 链表分区为已翻转部分+待翻转部分+未翻转部分
 * 每次翻转前，要确定翻转链表的范围，这个必须通过 k 此循环来确定
 * 需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
 * 初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
 * 经过k此循环，end 到达末尾，记录待翻转链表的后继 next = end.next
 * 翻转链表，然后将三部分链表连接起来，然后重置 pre 和 end 指针，然后进入下一次循环
 * 特殊情况，当翻转部分长度不足 k 时，在定位 end 完成后，end==null，已经到达末尾，说明题目已完成，直接返回即可
 *
 * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @create 2025-02-16 17:05
 **/
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode cur = head;

        ListNode pre = dummy;

        while(cur != null){
            ListNode rightTargetNode = cur;
            for(int i = 1; i < k && rightTargetNode != null; i++){
                rightTargetNode = rightTargetNode.next;
            }
            // 不足k个，则不反转
            if(rightTargetNode == null){
                pre.next = cur;
                break;
            }
            // 记录下一个要反转的节点
            ListNode right = rightTargetNode.next;

            // 断键
            rightTargetNode.next = null;

            // 反转链表
            ListNode reverseNode = reverseLinkedList(cur);

            pre.next = reverseNode;

            // 记录前驱节点
            pre = cur;

            // 开始下一轮反转
            cur = right;
        }

        return dummy.next;
    }

    public ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode res = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
