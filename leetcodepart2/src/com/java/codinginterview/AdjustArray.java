package com.java.codinginterview;

import java.util.Arrays;

/**
 * @author xing
 * @create 2021-03-24 16:56
 */
public class AdjustArray {
    public int[] exchange(int[] nums) {
        if(nums.length == 0 || nums == null)
            return nums;
        // 快慢指针
        int left = 0;
        int right = 0;
        while(right < nums.length){
            // 当前数字为奇数
            if(isOdd(nums[right])){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }

    public int[] exchange1(int[] nums) {
        if(nums.length == 0 || nums == null)
            return nums;
        // 首尾指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) != 0) {
                left ++;
                continue;
            }
            if ((nums[right] & 1) != 1) {
                right --;
                continue;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        return nums;
    }

    public boolean isOdd(int num){  // 判断奇偶
        return num % 2 == 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        AdjustArray aa = new AdjustArray();
        int[] nums = new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        aa.exchange1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
