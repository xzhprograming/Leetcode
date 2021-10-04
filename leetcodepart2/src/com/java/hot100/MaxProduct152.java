package com.java.hot100;

/**
 * @className: MaxProduct152
 * @description:
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 解题思路:
 * 动态规划
 * 错误状态转移方程：dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
 * 因为每个状态的结果会有正负性，所以当前位置的最优解未必是由前一个位置的最优解转移得到的。
 * 正负性讨论dp：
 * 使用max和min两个数组维护
 * max[i]:第i位置上的乘积最大值
 * min[i]:第i位置上的乘积的最小值
 * @author: xingzihao
 * @date: 2021/10/4
 **/
public class MaxProduct152 {

}

class MaxProductSolution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        // base case
        max[0] = nums[0];
        min[0] = nums[0];
        for(int i = 1; i < n; i++){
            // 考虑到负负得正，用max和min两个数组来维护
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(nums[i], max[i - 1] * nums[i]));
        }
        int ans = max[0];
        for(int i = 1; i < max.length; i++){
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}


/**
 * 优化：
 * 由于第 i 个状态只和第 i - 1个状态相关，根据「滚动数组」思想，我们可以只用两个变量来维护 i - 1 时刻的状态，一个维护 max, 一个维护 min
 */
class MaxProductSolution1 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++){
            int tmpMax = max;
            int tmpMin = min;

            max = Math.max(tmpMax * nums[i], Math.max(nums[i], tmpMin * nums[i]));
            min = Math.min(tmpMin * nums[i], Math.min(nums[i],tmpMax * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
