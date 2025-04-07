package linkedList;

import common.ListNode;

/**
 * @author xingzihao
 * @description
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 思路：
 * way1:迭代法
 * 1.截取left和right之间的节点单独做翻转，并记录left前一个节点和right后一个节点，在翻转后从新将链表进行连接
 * 2. 小技巧：建立虚拟节点，以应对left=1时的特殊情况
 *
 * @create 2025-02-16 13:39
 **/
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 建立虚拟节点，防止从第一位开始翻转的特殊情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 0; i < left -1; i++){
            pre = pre.next;
        }

        ListNode leftNode = pre.next;

        ListNode rightNode = pre;

        for(int i = 0; i < right - left + 1; i++){
            rightNode = rightNode.next;
        }

        ListNode successor = rightNode.next;

        // 断链
        pre.next = null;
        rightNode.next = null;

        ListNode newStartNode = reverse(leftNode);

        pre.next = newStartNode;
        leftNode.next = successor;
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(listNode);
        Solution92 solution92 = new Solution92();
        ListNode head = solution92.reverseBetween(listNode, 2, 4);
        System.out.println(head);
    }
}
