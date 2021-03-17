package com.java.array;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * @author xing
 * @create 2021-03-17 21:37
 */
public class TwoSumTest {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;  // 左指针
        int end = numbers.length - 1;  //右指针
        while(start < end){
            if(numbers[start] + numbers[end] > target){
                end--;
            }
            else if (numbers[start] + numbers[end] < target){
                start++;
            }
            else{
                return new int[]{start + 1, end + 1};
            }
        }
        return new int[]{};
//        return new int[0];
    }

    public static void main(String[] args) {
        TwoSumTest t = new TwoSumTest();
        int[] nums = new int[]{1,2,3};
        int[] res = t.twoSum(nums, 8);
        System.out.println(Arrays.toString(res));
    }
}
