package com.java.codinginterview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列'用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 *

 * @author xing
 * @create 2021-03-19 23:09
 */
public class CQueue {
    private Deque<Integer> instack;
    private Deque<Integer> outstack;

    public CQueue() {
        this.instack = new LinkedList<>();
        this.outstack = new LinkedList<>();
    }

    public void appendTail(int value) {
        instack.push(value);
    }

    public int deleteHead() {
        //两个栈都为空时
        if(outstack.isEmpty() && instack.isEmpty())
            return -1;
        // 如果outstack不为空，直接弹出栈顶元素
        if(!outstack.isEmpty())
            return outstack.pop();
        // outstack为空的时候再将instack的元素全部压入outstack
        // outstack在弹出栈顶元素
        while(!instack.isEmpty())
            outstack.push(instack.pop());
        return outstack.pop();
    }
}
