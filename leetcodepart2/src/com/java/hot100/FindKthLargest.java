package com.java.hot100;

import java.util.Random;

/**
 * @className: FindKthLargest
 * @description: TODO
 * @author: xingzihao
 * @date: 2021/9/27
 **/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        quickSelect(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    public void quickSelect(int[] nums, int start, int end, int k){
        if(start >= end){
            return;
        }
        int index = parition(nums, start, end);
        if(index == k){
            return;
        } else if(index > k){
            quickSelect(nums, start, index - 1, k);
        } else{
            quickSelect(nums, index + 1, end, k);
        }
    }

    public int parition(int[] nums, int start, int end){
        int index = new Random().nextInt(end - start + 1) + start;
        swap(nums, index, end);
        int small = start; // 记录比index位置小的数
        for(int i = start; i < end; i++){
            if(nums[i] < nums[end]){
                swap(nums, small, i);
                small++;
            }
        }
        swap(nums, small, end);
        return small;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
