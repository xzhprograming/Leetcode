package com.java.codinginterview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xing
 * @create 2021-03-19 21:01
 */
public class DuplicateNumber_03 {
    public int findRepeatNumber(int[] nums) {
        // 边界条件

        int n = nums.length;
        int[] count = new int[n];

        for(int i = 0; i < n; i++){
            count[nums[i]] = count[nums[i]] + 1;
            if(count[nums[i]] > 1)
                return nums[i];
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        // 边界条件
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        DuplicateNumber_03 d = new DuplicateNumber_03();
        System.out.println(d.findRepeatNumber(nums));
    }
}
