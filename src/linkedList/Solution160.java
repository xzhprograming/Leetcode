package linkedList;

/**
 * @author xingzihao
 * @description
 * 160. 相交链表
 *给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @create 2025-03-25 22:48
 **/
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode A = headA;
        ListNode B = headB;

        while(A != null){
            lenA++;
            A = A.next;
        }

        while(B != null){
            lenB++;
            B = B.next;
        }

        ListNode forward = null;
        if(lenA > lenB){
            forward = headA;
            int step = lenA - lenB;
            while(step-- > 0){
                forward = forward.next;
            }
            B = headB;
            while(B != null && forward != null){
                if(B == forward){
                    return B;
                }
                B = B.next;
                forward = forward.next;
            }
        } else {
            forward = headB;
            int step = lenB - lenA;
            while(step-- > 0){
                forward = forward.next;
            }
            A = headA;
            while(A != null && forward != null){
                if(A == forward){
                    return A;
                }
                A = A.next;
                forward = forward.next;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // 利用公共尾部的思想
        // 设公共尾部为c, headA长度为a, headB长度为b
        //则 headA走完之后走headB: a + (b - c) = headB走完之后走headA: b + (a - c)
        //则两节点相遇时，即为相交节点
        ListNode A = headA;
        ListNode B = headB;

        while(A != B){
            if(A == null){
                A = headB;
            } else {
                A = A.next;
            }

            if(B == null){
                B = headA;
            } else {
                B = B.next;
            }
        }
        return A;
    }
}
