package com.java.datastructure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * 解题思路：
 * <p>
 * 将一个栈当作输入栈，用于压入push 传入的数据；另一个栈当作输出栈，用于 pop 和 peek 操作。
 * <p>
 * 每次 pop 或 peek 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
 *
 * @author xing
 * @create 2021-03-15 23:22
 */
public class MyQueue {
    //使用双栈实现队列
    private Deque<Integer> inStack, outStack;

    // 构造函数
    public MyQueue() {
        this.inStack = new LinkedList<>();
        this.outStack = new LinkedList<>();
    }

    //入队操作
    public void push(int x) {
        inStack.push(x);
    }

    //出队操作
    public int pop() {
        //若栈2为空，则将栈1的元素依次弹出压入栈2
        outAndIn();
        return outStack.pop();
    }

    // 取队首元素
    public int peek() {
        //若栈2为空，则将栈1的元素依次弹出压入栈2
        outAndIn();
        return outStack.peek(); // 这里的返回值使用到了类的泛型,因此声明Deque是必须声明泛型的类型
    }

    // 判断队列是否为空，两个栈都为空，队列才为空
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void outAndIn() {
        //若栈2为空，则将栈1的元素依次弹出压入栈2
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}
