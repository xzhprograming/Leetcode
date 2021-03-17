package com.java.array;


import com.java.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *题目：给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 解题思路：
 * 我们使用两个指针，fast 与 slow。它们起始都位于链表的头部。随后，slow 指针每次向后移动一个位置，而 fast 指针向后移动两个位置。如果链表中存在环，
 * 则 fast 指针最终将再次与 slow 指针在环中相遇。
 *
 * 如下图所示，设链表中环外部分的长度为 a. 指针进入环后，又走了 b的距离与 fast 相遇。此时，fast 指针已经走完了环的 nn 圈，
 * 因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc。
 据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
 a+(n+1)b+nc=2(a+b)
 a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)

 有了 a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。

 * @author xing
 * @create 2021-03-17 21:08
 */
public class LinkedListCycle
{
    // way1:快慢指针
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){ // 若fast与slow第一次相遇,说明此链表有环
                ListNode pre = head;
                while(pre != slow){
                    pre = pre.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    // way2: HashSet集合
    public ListNode detectCycle1(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode pre = head;
        while(pre != null){
            // 如果集合中有此节点，那么此节点有环且此节点为入环点
            if(set.contains(pre)){
                return pre;
            }
            set.add(pre);
            pre = pre.next;
        }
        return null;
    }
}
