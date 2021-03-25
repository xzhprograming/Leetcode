package com.java.codinginterview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xing
 * @create 2021-03-25 10:41
 */
public class StackPushPopTest {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 边界条件
        // 两个序列长度不相等
        if(pushed.length != popped.length)
            return false;
        //定义辅助栈
        Deque<Integer> stack = new LinkedList<>();
        int pushStart = 0;
        int popStart = 0;
        while(pushStart < pushed.length && popStart < popped.length){
            // 先比较栈顶元素，不相等再压栈
            // 若栈顶元素与poped当前指向数组元素相等
            if(!stack.isEmpty() && stack.peek().intValue() == popped[popStart]){
                stack.pop();
                popStart++;
            }
            else{ // 不相等则压栈
                stack.push(pushed[pushStart]); // 将pushed压入辅助栈中
                pushStart++;
            }
        }
        // 若当前栈非空，则说明poped元素没有比较完，且其序列与栈中元素
        // 相同：则为出栈序列
        // 不相同：则不是出栈序列
        while(!stack.isEmpty() && popStart < popped.length){
            if(stack.pop().intValue() != popped[popStart])
                return false;
            popStart++;
        }
        return true;
    }
}
