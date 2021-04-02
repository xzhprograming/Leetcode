package com.java.codinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 * 排序数组中的搜索问题，首先想到 二分法 解决。
 * 缺失的数字等于 “右子数组的首位元素” 对应的索引；因此考虑使用二分法查找 “右子数组的首位元素”
 * @author xing
 * @create 2021-04-01 22:04
 */
public class MissNumber53 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        // 二分查找
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == mid){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }

    public static int testList(List<Integer> list){
        Integer[] nums = new Integer[]{0,1,26,7,9};
        List<Integer> list2 = Arrays.asList(nums);

        List<Integer> list1= new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){
            list1.add(nums[i]);
        }

//        list = list1;
        System.out.println(list);
        list.set(1, 20);
        System.out.println(list1);
        System.out.println(list);
        return 0;
    }

    public static void testString(String s){
        s = new String("abcg");
    }

    public static void main(String[] args) {
        String s = new String("abcdefg");
        testString(s);
        System.out.println(s);
        int[] nums = new int[]{0,1,2,3,4,5,6,7,9};
        List<Integer> listTest = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){
            listTest.add(nums[i]);
        }
        testList(listTest);
        System.out.println(listTest);
    }
}
