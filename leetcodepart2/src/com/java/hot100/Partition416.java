package com.java.hot100;

import java.util.Arrays;

/**
 * @className: Partition416
 * @description:
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * 解题思路：
 * 动态规划
 *
 * @author: xingzihao
 * @date: 2021/10/3
 **/
public class Partition416 {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        // 动态规划0-1背包问题
        //计算数组和
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int target = sum / 2;
        //边界条件
        // 1. 和为奇数，返回false
        // 2. 和为偶数，若数组中的最大值大于target，返回false
        if (sum % 2 == 0) {
            if (max > target) {
                return false;
            }
        } else {
            return false;
        }

        int n = nums.length;
        // 定义dp数组，dp[i][j]含义：从nums数组[0,i]下标中选取若干个正整数，使得和为j
        boolean[][] dp = new boolean[n][target + 1];
        // base case
        // 当和为0时
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // 当只能选取nums[0]时
        dp[0][nums[0]] = true;
        // 其余情况
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                // 两种情况：
                // 1. num[i] <= j
                // 当不选取nums[i]的时候dp[i][j] = dp[i - 1][j]
                // 当选取nums[i]的时候dp[i][j] = dp[i - 1][j - nums[i]]
                // 2. num[i] > j
                // 则nums[i]不可能被选取，dp[i][j] = dp[i - 1][j]
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        Partition416Solution solution = new Partition416Solution();
        int[] nums = new int[]{1,2,3,6};
        solution.canPartition(nums);
    }
}

/**
 * 二维dp降为一维
 */
class Partition416Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = num; j <= target; j++) {
                dp[j] |= dp[j - num];
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[target];
    }

    public void print(int[][] nums){
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[0].length; j++){
                System.out.print(nums[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

