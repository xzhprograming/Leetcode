package com.java.codinginterview;

import com.java.utils.ListNode;

/**
 * @author xing
 * @create 2021-03-31 22:51
 */
public class LinkedList52 {
    // 两链表若有公共节点，则从公共节点到尾部的长度相同
    // 两指针谁长先走谁，然后同时前进，相遇的第一个节点即为公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int headALength = 0;
        int headBLength = 0;
        ListNode A = headA;
        ListNode B = headB;
        while(A != null){
            A = A.next;
            headALength++;
        }
        while(B != null){
            B = B.next;
            headBLength++;
        }
        if(headALength > headBLength){ // A长度大于B
            int temp = headALength - headBLength;
            while(temp > 0){
                headA = headA.next;
                temp--;
            }
        }
        else{
            int temp = headBLength - headALength;
            while(temp > 0){
                headB = headB.next;
                temp--;
            }
        }

        while(headA != null && headB != null){
            if(headA == headB){ // 若两指针相遇
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
