package doublepointer.slidewindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 53. 最大子数组和
 * @create 2025-02-15 20:39
 **/
public class Solution53 {

    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int maxValue = Integer.MIN_VALUE;

        int left = 0;
        int right = 1;
        int initSum = nums[0];

        while(right <= nums.length - 1){
            if(initSum < 0){
                initSum = 0;
            }
            initSum += nums[right];
            maxValue = Math.max(maxValue, initSum);
            right++;
        }
        return maxValue;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1, -3};
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(nums));
    }
}
