package com.java.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeSort {
    public int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right)
            return;
        int mid = (left + right) >> 1;
//        int mid = left + (right - left) / 2; // 防止加法溢出
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // 合并两个有序链表
        int pleft = left;
        int pright = mid + 1;
        int count = 0;
        while (pleft <= mid && pright <= right) {
            if (nums[pleft] >= nums[pright]) {
                temp[count++] = nums[pright++];
            } else {
                temp[count++] = nums[pleft++];
            }
        }
        while (pright <= right) {
            temp[count++] = nums[pright++];
        }
        while (pleft <= mid) {
            temp[count++] = nums[pleft++];
        }
//        System.out.print(left);
//        System.out.print("   ");
//        System.out.print(right);
//        System.out.println(Arrays.toString(temp));
//        for (int i = 0; i < right - left + 1; i++) {
        for (int i = 0; i < count; i++) {
            nums[left + i] = temp[i];  // left + i才是最终的下标
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();

//        Integer[] nums = new Integer[]{5, 1, 1, 2, 0, 0};
//        Arrays.sort(nums, new myComparator());
//        System.out.println(Arrays.toString(nums));

        int[] nums = new int[]{5, 1, 1, 2, 7, 9};
        ms.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class myComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;

        return -i1.compareTo(i2);
    }
}