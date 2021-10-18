package com.java.utils;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xing
 * @create 2021-03-07 19:12
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public ListNode constructlist(String str) {
        int last = 0;
        ListNode[] list = new ListNode[10];
        for (int i = 0; i < str.length(); i++) {
            list[i] = new ListNode(str.charAt(i) - '0');
        }
        for (int i = 0; i < str.length() - 1; i++) {
            last = i;
            list[i].next = list[i + 1];
        }
        list[++last] = null;
        return list[0];
    }

    public ListNode constructlist(List<Integer> list){
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        for (int num : list){
            pre.next = new ListNode(num);
            pre = pre.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        String s = "15340";
        int[] nums = new int[]{-1,5,3,4,0};
        List<Integer> list = new ArrayList<>();
        for (int num : nums){
            list.add(num);
        }
        ListNode node = listNode.constructlist(s);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }

        ListNode listNode1 = listNode.constructlist(list);

        while(listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}