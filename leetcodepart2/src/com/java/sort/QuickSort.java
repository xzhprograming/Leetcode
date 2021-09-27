package com.java.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    // 快速排序,每次都能确定一个位置
    public static void quickSort(int[] nums, int left, int right){
//        终止条件
        if(left >= right){
            return;
        }

        if (left < right){
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1); // 将分界值左边排序
            quickSort(nums, index + 1, right); // 将分界值右边排序
        }

    }

    public static int partition(int[] nums, int start, int end){
        // 随机选取一个值作为分界值
        int index = new Random().nextInt(end - start + 1) + start; // nextInt（左闭右开）
        int target = nums[index];

        swap(nums, index, end); // 将选中的值交换到末尾
        int small = start - 1; // small记录小于target的值的位置
        // 将小于target值的元素
        for (index = start; index < end; index++){
            if (nums[index] < target){
                small++;
                if (small != index)
                    swap(nums, index, small);  // 找到了比target小的值，则将当前位置元素与small位置元素交换
            }
        }
        small++;
        swap(nums, small, end);  // 交换目标值与small记录的位置，
        return small;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
