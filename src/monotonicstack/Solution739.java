package monotonicstack;

import java.util.Stack;

/**
 * @author xingzihao
 * @description
 *
 * 739.每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * @create 2025-02-18 23:13
 **/
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 出现下一个更高温度在几天后， 即计算离更高温度时间的距离
        // 距离=更高温度时间 - 当前时间，在数组中则表示为下标间的距离，假设当前时间i,更高温度时间为j，则距离=j-i
        // 单调递减栈
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
