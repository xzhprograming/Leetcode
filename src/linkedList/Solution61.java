package linkedList;

import common.ListNode;

/**
 * @author xingzihao
 * @description
 * 61. 旋转链表
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 思路：
 * 核心思想：将链表首尾相连形成环，通过数学计算找到新的头节点位置，最后断开环
 *  1.处理边界情况：链表为空或仅有一个节点时直接返回。
 *  2. 计算长度并成环：遍历链表计算长度 size，同时将尾节点指向头节点形成环。
 *  3.确定新头位置：旋转 k 次等价于将后 k % size 个节点移到链表前面。因此，新头节点的位置是 size - k % size。
 *  4.定位并断环：移动指针到新头节点的前驱位置，断开环并返回新头节点。
 *
 * @create 2025-03-19 23:19
 **/
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 1;
        ListNode start = head;
        ListNode end = head;
        while(end.next != null){
            end = end.next;
            len++;
        }
        // 成环
        end.next = start;

        // k % size 处理 k 大于链表长度的情况
        int step = len - k % len;

        ListNode forward = end;
        while(step > 0){
            forward = forward.next;
            step--;
        }
        // 新头结点
        ListNode res = forward.next;
        // 断环
        forward.next = null;
        return res;
    }
}
