import java.util.ArrayList;
import java.util.List;

/**
 *
 * 234. 回文链表
 * 题目：请判断一个链表是否为回文链表。
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 思路：
 * 因为回文串是对称的，所以正着读和倒着读应该是一样的，这一特点是解决回文串问题的关键。
 *
 *情况1：给定的为链表时，使用递归得到链表的后序遍历序列，再与原链表进行对比，类似双指针
 *
 * 链表其实也可以有前序遍历和后序遍历：
 *
 * void traverse(ListNode head) {
 *     // 前序遍历代码
 *     traverse(head.next);
 *     // 后序遍历代码
 * }
 *
 * 情况2：给定的为数组时，使用双指针，直接利用下标获取元素进行比较
 * @author xing
 * @create 2021-03-07 12:32
 */

class ListNode {
    char val;
    ListNode next;
    ListNode() {}
    ListNode(char val) { this.val = val; }
    ListNode(char val, ListNode next) { this.val = val; this.next = next;}

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public ListNode constructlist(String str){
        int last = 0;
        ListNode[] list  = new ListNode[10];
        for (int i = 0; i < str.length(); i++){
            list[i] = new ListNode(str.charAt(i));
        }
        for (int i = 0; i < str.length() - 1; i++){
            last = i;
            list[i].next = list[i + 1];
        }
        list[++last] = null;
        return list[0];
    }
}

public class Solution {
    /*情况1：给定的链表
    * 使用递归，后序遍历链表，再与头结点进行比较
    * 时间复杂度：O(n)
    * 空间复杂度：O(n)
    *
    * 使用双指针中的快慢指针*/
    ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right){
        if(right == null)
            return true;
        //链表后序遍历
        boolean res = traverse(right.next);
        res = res && (right.val == left.val); //使用最后一个和第一个比较，类似于双指针的操作
        left = left.next;
        return res;
    }

    public boolean isPalindrome1(ListNode head) {
        //特殊情况：
        if (head == null)
            return true;
        //1.定义快慢指针
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) { // 确保当前节点可以前进2步
            slow = slow.next;// slow forward one step
            fast = fast.next.next; // fast forward two steps
        }
        //2.确定中间节点位置
        if (fast != null){ //链表长度为奇数
            slow = slow.next;
        }
        //3.慢指针指向中间节点后，反转慢指针后的节点
        ListNode res = reverse(slow);
        //4.将反转后的后半段链表与head头结点依次进行比较
        while (head != null && res != null){
            if (head.val != res.val){
                return false;
            }
            head = head.next;
            res = res.next;
        }
        return true;
    }

    // reverse the linkedlist
    public ListNode reverse(ListNode slow){
        ListNode cur = null;
        ListNode tmp = null;
        while(slow != null){
            tmp = slow.next;
            slow.next = cur;
            cur = slow;
            slow = tmp; // slow forward
        }
        return cur;
    }



//    情况2：给定的为数组
    public boolean isPalindrome2(String str){
        int l = 0;
        int r = str.length() - 1;
        while (l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public static void main(String[] args) {
        String a = "1221";
        ListNode ln = new ListNode();
        ListNode head = ln.constructlist(a);
        ListNode head1 = ln.constructlist(a);
//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
        System.out.println(solution.isPalindrome1(head1));
        System.out.println(solution.isPalindrome2(a));
    }
}