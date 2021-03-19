package com.java.codinginterview;

import com.java.utils.ListNode;

import java.util.*;

/**
 * @author xing
 * @create 2021-03-19 21:41
 */
public class PrintLinkedList_06 {
    public int[] reversePrint(ListNode head) {
        //边界条件
        if(head == null){
            return new int[0];
        }
        Deque<Integer> dq = new LinkedList<>(); // 初始化一个栈
        //将节点压入栈中
        while(head!=null){
            dq.push(head.val);
            head = head.next;
        }
        int size = 0;
        int n = dq.size();
        int[] ans = new int[n];

        while(!dq.isEmpty()){
            ans[size++] = dq.pop();
        }
        return ans;
    }
}
