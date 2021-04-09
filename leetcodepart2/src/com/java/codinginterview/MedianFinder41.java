package com.java.codinginterview;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4]的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 解题思路：
 * 创建两个堆，一个小顶堆A、一个大顶堆B
 * A和B各存放一半元素，其中A存放较大的一半元素，B存放较小的一半元素
 *
 * @author xing
 * @create 2021-04-09 21:44
 */
public class MedianFinder41 {
    Queue<Integer> minQueue;
    Queue<Integer> maxQueue;
    /** initialize your data structure here. */
    public MedianFinder41() {
        minQueue = new PriorityQueue<>(); // 小顶堆
        maxQueue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1)); // 大顶堆
    }

    public void addNum(int num) {
        // 当 m != n
        // 为 奇数：需向 B 添加一个元素。实现方法：将新元素 num 插入至 A ，再将 A 堆顶元素插入至 B ；
        if(minQueue.size() != maxQueue.size()){
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
        }
        else{
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        double ans = 0;
        if (minQueue.size() != maxQueue.size())
            ans = minQueue.peek();
        else{
            ans = (minQueue.peek() + maxQueue.peek()) / 2.0;
        }
        return ans;
    }

    public static void main(String[] args) {
        MedianFinder41 obj = new MedianFinder41();
        int num = 1;
        obj.addNum(num);
        double param_2 = obj.findMedian();
    }
}
