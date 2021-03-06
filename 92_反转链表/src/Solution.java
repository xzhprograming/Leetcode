/**
 * @author xing
 * @create 2021-03-06 21:33
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    //way1：/*找到对应的节点将其翻转并拼接到现在的链表中*/
    ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 找到第left - 1个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        //找到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;//找到第left个节点，截断链表
        ListNode curr = rightNode.next;
        //切断链接：细节需注意
        pre.next = null;
        rightNode.next = null;
        //反转链表
        reverseLinkedList(leftNode);
        //拼接链表
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    void reverseLinkedList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;//添加pre引用，防止leftNode值被修改
        while (pre != null) {
            ListNode tmp = pre.next; //保存下一个节点
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
    }

    /*way2:递归
    * */
    ListNode reverseBetween1(ListNode head, int left, int right) {
        //先反转前n个节点
        return null;
    }

}
