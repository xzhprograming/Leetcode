package com.java.sort;

import java.util.Random;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] nums) {
        // 冒泡排序
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,6,7,9};
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(nums)));
    }

}
