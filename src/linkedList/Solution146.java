package linkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xingzihao
 * @description
 * 146. LRU 缓存
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @create 2025-03-23 10:19
 **/
public class Solution146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.get(1);
        lRUCache.put(3, 3);
        lRUCache.get(2);
        lRUCache.put(4, 4);
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
    }

}

class LRUCache {
    int capacity;
    ListNode dummyHead;
    ListNode dummyTail;
    Map<Integer, ListNode> map = new HashMap<>();



    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 虚拟头尾节点，方便插入和删除，不需要判断其前驱和后继节点是否为null
        dummyHead = new ListNode(-1, -1);
        dummyTail = new ListNode(-2, -2);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    // 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
    // 使用Map缓存key value
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            // 断键重连
            ListNode pre = node.prev;
            ListNode next = node.next;
            pre.next = next;
            next.prev = pre;
            // 将node头插,保证最新
            insertToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 包含key,修改值并头插
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            insertToHead(node);
        } else{
            // 不包含，则判断容量，容量未满，直接插入，满了，先淘汰后头插
            ListNode n2 = new ListNode(key, value);
            map.put(key, n2);
            // 容量未满
            if(capacity > 0){
                // 头插
                insertToHead(n2);
                capacity--;
            } else{
                // 先淘汰，再头插
                ListNode pre1 = dummyTail.prev;
                ListNode pre2 = pre1.prev;
                pre2.next = dummyTail;
                dummyTail.prev = pre2;
                // 更新cache
                map.remove(pre1.key);
                insertToHead(n2);
            }
        }
    }

    public void insertToHead(ListNode node){
        ListNode next = dummyHead.next;

        node.prev = dummyHead;
        dummyHead.next = node;

        node.next = next;
        next.prev = node;
    }
}



class ListNode{
    int val;
    int key;
    ListNode prev;
    ListNode next;

    public ListNode(int key,int val){
        this.val = val;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
