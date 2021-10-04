package com.java.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: TargetSum494
 * @description: 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 解题思路：
 * 1. 回溯法：假设数据nums长度为n，则每个元素前添加符号的方法有两种，则共可以有2^n个表达式，用count记录表达式结果为target的个数
 * 2. 动态规划
 * @author: xingzihao
 * @date: 2021/10/3
 **/
public class TargetSum494 {

    public static void main(String[] args) {
        int[] nums = new int[]{16,40,9,17,49,32,30,10,38,36,31,22,3,36,32,2,26,17,30,47};
        int target = 49;
        TargetSolution1 targetSum494 = new TargetSolution1();
        int targetSumWays = targetSum494.findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }
}

// dfs超时：可能是得到所有表达式后再计算和耗时过多
class TargetSolution1 {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        // dfs搜索
        backtrack(nums, target, new ArrayList<>(), 0);
        return count;
    }

    public void backtrack(int[] nums, int target, List<Integer> arr, int start) {
        if (arr.size() == nums.length) {
            int sum = 0;
            for (int a : arr) {
                sum += a;
            }
            if (sum == target) {
                count++;
            }
            return;
        }
        int[] symbol = new int[]{-1, 1};
        for (int i = 0; i < symbol.length; i++) {
            arr.add(symbol[i] * nums[start]);
            backtrack(nums, target, arr, start + 1);
            arr.remove(arr.size() - 1);
        }
    }
}

// 在dfs过程中计算得到的和，不用得到最终表达式后再计算和
class TargetSolution1Improve {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        // dfs搜索
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int sum,int start){
        if(start == nums.length){
            if(sum == target){
                count++;
            }
            return;
        }
        int[] symbol = new int[]{-1, 1};
        for (int i = 0; i < symbol.length; i++){
            sum += symbol[i] * nums[start];
            backtrack(nums, target, sum, start + 1);
            sum -= symbol[i] * nums[start];
        }
    }
}

// 答案回溯法
class TargetSolution2 {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}

/**
 * 动态规划
 * 与leetcode416题较为相似
 * 不同的一个只需要判断是否能达到目标和
 * 而此题需要求出达到此目标和的方法种数
 * 边界条件的base case有所改变
 * 解题思路：
 * 问题转化：
 * 设数组元素的和为sum，添加-号的元素之和为neg,则添加+号的元素和为sum - neg，则此时添加完符号的数组和为(sum - neg) - neg = target
 * 即 neg = (sum - target) / 2
 * 则问题转化为：从数组元素总选取若干个数字，使其和为neg
 * 由于数组 nums 中的元素都是非负整数，neg 也必须是非负整数，所以上式成立的前提是 sum−target 是非负偶数。若不符合该条件可直接返回 0。
 * 定义二维数组 dp，其中 dp[i][j] 表示在数组 nums 的前 i 个数中选取元素，使得这些元素之和等于 j 的方案数。假设数组 nums 的长度为 n，则最终答案为 dp[n][neg]。
 * 边界条件:
 * dp[0][0] = 1
 * dp[0][j] = 0, j >= 1
 *其余状态:
 * dp[i][j] = dp[i - 1][j] , j < nums[i]
 * dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]] ,  j >= nums[i]
 */
class TargetSolution3 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums){
            sum += num;
        }
        // 若sum-target为奇数
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0){
            return 0;
        }
        int neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= neg; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= neg; j++){
                if(j >= nums[i - 1]){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][neg];
    }
}

