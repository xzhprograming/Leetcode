package doublepointer.linkedlist;

import common.ListNode;

/**
 * @author xingzihao
 * @description
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * 解题思路：与26题数组双指针问题类似，但是链表需要涉及到相关的断链，重新链接操作
 *  快慢指针: slow和fast同时指向第一个元素，fast先行
 *  若fast元素 == slow元素，则fast继续前进
 *  若fast元素 != slow元素，则slow前进一步，并将fast元素值赋给slow元素
 *  若fast元素 != slow元素，则slow下一个节点指向fast，并前进一步
 *  维护 nums[0..slow] 无重复
 *  最后还需要断开与后面重复元素的连接
 * @create 2025-01-19 14:55
 **/
public class Sloution83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode res = head;
        ListNode fast = head;

        ListNode slow = res;

        while(fast != null){
            if(fast.getVal() != slow.getVal()) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return res;
    }
}
