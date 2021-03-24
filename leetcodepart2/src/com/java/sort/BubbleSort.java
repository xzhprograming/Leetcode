package com.java.sort;

import java.util.Random;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] nums) {
        // 冒泡排序
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - i; j++){
                if(nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }


}
