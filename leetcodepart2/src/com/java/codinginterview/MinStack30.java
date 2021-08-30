package com.java.codinginterview;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack30 {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;  // min stack
    /** initialize your data structure here. */
    public MinStack30() {
        stack1  = new LinkedList<>();
        stack2  = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || !stack2.isEmpty() && stack2.peek() >= x){
            stack2.push(x);
        }
    }

    public void pop() {
        if(!stack1.isEmpty()){
            if(stack1.peek().equals(stack2.peek())){
                stack2.pop();
            }
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */