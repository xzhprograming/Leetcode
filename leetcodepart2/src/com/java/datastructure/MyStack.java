package com.java.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。

 实现 MyStack 类：

 void push(int x) 将元素 x 压入栈顶。
 int pop() 移除并返回栈顶元素。
 int top() 返回栈顶元素。
 boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * @author xing
 * @create 2021-03-16 0:09
 */
public class MyStack {
    // 双队列实现栈
    //单队列实现栈
    Queue<Integer> queue;

    public MyStack(){
        this.queue = new LinkedList<>();
    }

    public void push(int x){
        queue.offer(x);
        int size = queue.size();
        // 将队列元素依次出队添加到后面,使其存储元素的位置与栈的位置一样
        while (size > 1){
            queue.offer(queue.poll());
            size--;
        }
    }
    public int pop(){
        return queue.poll();
    }
    public int top(){
        return queue.peek();
    }
    public boolean empty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False
    }
}
