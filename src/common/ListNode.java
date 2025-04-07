package common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * @create 2025-01-19 14:55
 **/
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode cur = this;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list.toString();
    }

    public int hashCode() {
        return super.hashCode();
    }


    public static ListNode createListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummy.next;
    }

}
