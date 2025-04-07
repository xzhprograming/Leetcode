package dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * @create 2025-03-14 00:20
 **/
public class Solution213 {


    public int rob2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (nums.length == 3) {
            Arrays.sort(nums);
            return nums[2];
        }

        int robFirst = rob1(Arrays.copyOfRange(nums, 1, nums.length));
        int robLast = rob1(Arrays.copyOfRange(nums, 0, nums.length - 1));

        return Math.max(robFirst, robLast);
    }

    public int rob1(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }


    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // 0到n-2
        int[] dp1 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length - 1; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        // 1到n-1
        int[] dp2 = new int[nums.length];
        dp2[1] =  nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < nums.length; i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }
}
