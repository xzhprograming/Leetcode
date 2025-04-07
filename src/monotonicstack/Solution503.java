package monotonicstack;

import java.util.Stack;

/**
 * @author xingzihao
 * @description
 * 503. 下一个更大元素 II
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * @create 2025-02-19 22:55
 **/
public class Solution503 {

    public int[] nextGreaterElements(int[] nums) {
        // 使用单调栈记录下一个更大元素，但没办法循环搜索，如[5,4,3,2,1]
        // 将数组长度翻倍，即可查找到
        // 可以不用构造新数组，利用循环数组的技巧来模拟数组长度翻倍的效果
        Stack<Integer> stack = new Stack<>();

        int n = nums.length;
        int[] res = new int[n];

        for(int i = 2*n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i % n] >= stack.peek()){
                stack.pop();
            }
            res[i % n ] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
