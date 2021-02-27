public class Solution {
    //     Definition for singly-linked list.
    public class ListNode {
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
// 方法一：
//由于我们需要找到倒数第 n 个节点，因此我们可以使用两个指针 first 和 second 同时对链表进行遍历，并且 first 比 second 超前 n 个节点。
//当 first 遍历到链表的末尾时，second 就恰好处于倒数第 n 个节点。
//复杂度分析:
//时间复杂度：O(L)，其中 L 是链表的长度。
//空间复杂度：O(1)。
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 快慢指针
        ListNode first = head;
        ListNode second = head;
        while (n > 0) {
            first = first.next;
            n--;
        }
        //特殊情况
        //1.删除的节点为头节点
        if (first == null) return head.next;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
//    方法二:快慢指针设置头节点
public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head); //设置一个头节点,避免判断删除第一个节点的情况
    ListNode first = head;
    ListNode second = dummy;
    for (int i = 0; i < n; ++i) {
        first = first.next;
    }
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    ListNode ans = dummy.next;
    return ans;
}
}
