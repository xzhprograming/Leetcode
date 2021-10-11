package com.java.hot100;

/**
 * @className: Rob213
 * @description:
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 解题思路：
 * 1. 是198题打家劫舍的扩展版，此题由于首尾连接，我们可以进行两个选择，
 * 选取第一个不选最后一个，或者不选第一个选最后一个，所以可以将其转换为
 * 选择(0, length - 2) 或 (1, length - 1)的问题，从中选取最大值的问题
 * @author: xingzihao
 * @date: 2021/10/11
 **/
public class Rob213 {
}

class Rob213Solution1{
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int start, int end){
        int n = end - start + 1;
        int[] dp = new int[n];

        // base case
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start]);
        }
        return dp[n - 1];
    }
}

class Rob213Solution2{
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        int maxValue = 0;
        for (int i = start + 2; i <= end; i++) {
            maxValue = Math.max(first + nums[i], second);
            first = second;
            second = maxValue;
        }
        return second;
    }
}