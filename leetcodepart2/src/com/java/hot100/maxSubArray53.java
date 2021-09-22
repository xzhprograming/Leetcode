package com.java.hot100;

/**
 * @className: maxSubArray53
 * @description: 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 解题思路：
 * 1. 动态规划：dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
 * 2. 贪心：若当前位置nums[i] + sum = 0, 则将sum置为0，即若和为负则丢弃
 * @author: xingzihao
 * @date: 2021/9/22
 **/
public class maxSubArray53 {
     public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // base case
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int num : nums){
            if(sum < 0){
                sum = 0;
            }
            sum += num;
            max = max > sum ? max : sum;
        }
        return max;
    }
}
