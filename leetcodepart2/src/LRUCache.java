import java.util.HashMap;
import java.util.Map;

/**
 * @author xing
 * @create 2021-03-14 15:35
 */

/*
 * 解题思路：
 * 1.创建一个hash表和双向链表，链表用于维护当前节点的状态
 * 2.将最近最少使用的节点放在尾部
 * 3.将最近使用过的放在头部*/

public class LRUCache {

    //定义双向链表
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    //类需要维护一个哈希表,双向链表，双向链表的长度
    private int capacity;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    // 定义头结点和尾节点的双向链表
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    // 访问缓存的节点
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        //若节点不存在
        if (node == null) {
            return -1;
        }
        // 若此节点存在且被访问，那么需要将此节点移动到头部
        moveToHead(node);
        return node.val;
    }

    // 添加节点
    public void put(int key, int value) {
        DLinkedNode newnode = new DLinkedNode(key, value);
        // 如果此节点存在，更新cache此节点的值，同时将此节点移动到头部
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.key = key;
            node.val = value;
            moveToHead(node);
        } else {
            cache.put(key, newnode);
            // 如果此节点不存在，将其插入头部，且如果cache长度已满那么应该删除尾部节点
            if (capacity > 0) { // cache未满
                insertToHead(newnode);
                capacity--;
            } else {
                insertToHead(newnode);
                //更新cache
                cache.remove(tail.pre.key);
                // 删除尾部节点
                deleteTail();
            }
        }
    }

    private void insertToHead(DLinkedNode node) {
        DLinkedNode hNext = head.next;

        head.next = node;
        node.pre = head;
        node.next = hNext;
        hNext.pre = node;
    }

    private void deleteTail() {
        DLinkedNode tPre1 = tail.pre;
        DLinkedNode tPre2 = tPre1.pre;

        tail.pre = tPre2;
        tPre2.next = tail;
    }

    private void moveToHead(DLinkedNode node) {
        if (node == head.next){
            return;
        }
        DLinkedNode nodePre = node.pre;
        DLinkedNode nodeNext = node.next;


        insertToHead(node);

        nodePre.next = nodeNext;
        nodeNext.pre = nodePre;
    }

    private static void test1(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }

    private static void test2(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(3, 2);
        System.out.println(lRUCache.get(3));  // 2
        System.out.println(lRUCache.get(2)); // 1
        lRUCache.put(4, 3);
        System.out.println(lRUCache.get(2)); // 1
        System.out.println(lRUCache.get(3)); // -1
        System.out.println(lRUCache.get(4));  //3
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
