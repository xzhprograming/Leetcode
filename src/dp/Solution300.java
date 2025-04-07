package dp;

import java.util.Arrays;

/**
 * @author xingzihao
 * @description
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * 思路：
 * 动态规划
 * 1. 状态转移方程：dp[i] = Math.max(dp[j] + 1, dp[i]);
 * 2. 初始状态：dp[i] = 1;
 * 3. dp[i]代表以nums[i]结尾的最长递增子序列的长度
 * @create 2025-03-13 23:08
 **/
public class Solution300 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始状态
        Arrays.fill(dp, 1);

        int res = 0;
        // 状态转移
        for(int i = 0; i < nums.length; i++){
            // 依次遍历比当前位置小的数，取最大的dp[j]值，再拼接上当前位置，与当前位置的值dp[i]相比，取最大
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            // 记录最大值
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
