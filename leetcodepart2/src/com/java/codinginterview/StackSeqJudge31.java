package com.java.codinginterview;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 */
public class StackSeqJudge31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 特殊情況
        if(pushed.length != popped.length){
            return false;
        }

        // 定义辅助栈
        Deque<Integer> stack = new LinkedList<>();

        int i = 0;

        for(int num : pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek().intValue() == popped[i]){
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}