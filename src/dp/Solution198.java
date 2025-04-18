package dp;

/**
 * @author xingzihao
 * @description
 * 198. 打家劫舍
 *你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @create 2025-03-13 23:48
 **/
public class Solution198 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];

        for(int i = 2; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                max = Math.max(dp[j], max);
            }
            dp[i] = Math.max(max, dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    /**
     * 优化后版本
     * @param nums
     * @return
     */
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
}
