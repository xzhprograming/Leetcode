package com.java.codinginterview;

import com.java.utils.ListNode;

/**
 * @author xing
 * @create 2021-03-24 15:50
 */
public class DeleteNode_18 {
    public ListNode deleteNode(ListNode head, int val) {
        //设待删除节点为del,待删除节点下一个节点为delnext
        //则删除此节点，可以使用, 时间复杂度O(1)
        // del.val = delnext.val;
        // del.next = delnext.next;
        ListNode dummyNode = new ListNode(); // 定义虚拟节点
        dummyNode.next = head;
        ListNode temp = head;
        ListNode pre = dummyNode;

        while(temp != null){
            if(temp.val == val){
                pre.next = temp.next;
                break;
            }
            pre = temp;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}
