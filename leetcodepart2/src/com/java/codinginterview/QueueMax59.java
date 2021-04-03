package com.java.codinginterview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value需要返回 -1
 *
 * @author xing
 * @create 2021-04-03 14:53
 */
class QueueMax59 {
    // 双向队列单调不增，存储较大值
    Deque<Integer> dq;
    Queue<Integer> queue;

    public QueueMax59() {
        dq = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        // 队列为空的情况
        return dq.isEmpty() ? -1 : dq.peekFirst();
    }

    public void push_back(int value) {
        // 入队
        queue.offer(value);
        // 将当前dq中小于value的元素弹出，将value存入dq
        // 根据队列先入先出的特点，value一定比那些小于它的元素晚出队，所以只需保留value值，即可获取当前队列最大值
        // dq首部存储最大值,dq保存的元素单调不增，因为有可能有相同元素
        while (!dq.isEmpty() && dq.peekLast() < value) {
            dq.pollLast();
        }
        dq.offerLast(value);
    }

    public int pop_front() {
        // 队列为空的情况
        if (queue.isEmpty()) return -1;
        // 如果出队的元素为最大值，即与dq的首元素相等
        if (queue.peek().equals(dq.peekFirst()))
            dq.pollFirst();
        return queue.poll();
    }

    public static void main(String[] args) {
        QueueMax59 obj = new QueueMax59();
        int value = 2;
        int param_1 = obj.max_value();
        obj.push_back(value);
        int param_3 = obj.pop_front();
    }
}


/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
