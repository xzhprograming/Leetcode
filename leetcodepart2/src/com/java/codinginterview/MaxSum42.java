package com.java.codinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing
 * @create 2021-03-29 17:49
 */
public class MaxSum42 {
    public int maxSubArray(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (max < sum)
                    max = sum;
                sum += nums[j];
            }
            if (max < sum)
                max = sum;
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (sum <= 0){
                sum = nums[i];
            }
            else{
                sum += nums[i];
            }
            // 记录最大的子数组和
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }

    //dp
    public int maxSubArray2(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0)
            return 0;
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int max = Math.max(nums[i - 1], 0);
            nums[i] = nums[i] + max;
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSum42 ms = new MaxSum42();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = ms.maxSubArray(nums);
        System.out.println(ans);
    }
}
