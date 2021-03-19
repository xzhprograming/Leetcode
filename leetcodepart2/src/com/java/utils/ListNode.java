package com.java.utils;

/**
 * @author xing
 * @create 2021-03-07 19:12
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(char val) {
        this.val = val;
    }

    ListNode(char val, ListNode next) {
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
            list[i] = new ListNode(str.charAt(i));
        }
        for (int i = 0; i < str.length() - 1; i++) {
            last = i;
            list[i].next = list[i + 1];
        }
        list[++last] = null;
        return list[0];
    }
}