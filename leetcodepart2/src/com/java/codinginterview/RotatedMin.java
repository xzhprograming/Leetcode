package com.java.codinginterview;

import java.util.Arrays;

/**
 *
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *

 * @author xing
 * @create 2021-03-20 18:05
 */
public class RotatedMin {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return 0;
        Arrays.sort(numbers);
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        // 边界条件
        if(numbers == null || numbers.length == 0)
            return 0;
        for(int i = 0; i < numbers.length; i++){
            // 若遍历到最后依然满足升序，返回第一个元素
            if(i == numbers.length - 1)
                return numbers[0];
            // 找到特殊元素
            // 如果当前元素大于后一个元素, 则后一个元素为最小数
            if(numbers[i] > numbers[i+1])
                return numbers[i + 1];
        }
        return 0;
    }

    class Solution {
        public int minArray(int[] numbers) {
            // 边界条件
            if(numbers == null || numbers.length == 0)
                return 0;
            //定义头尾指针
            int left = 0;
            int right = numbers.length - 1;
            int mid = left;
            // 特殊情况：当数组有序时，需要返回第一个元素

            //若两节点相邻,则找到最小值
            while(numbers[left] >= numbers[right]){
                if(left + 1 == right){
                    mid = right;
                    break;
                }
                mid = (left + right) / 2;

                // 如果三数相等则只能顺序查找
                if(numbers[left] == numbers[right] && numbers[mid] == numbers[right])
                    return minOrder(numbers, left, right);
                // 如果左指针小于中间指针的值，则mid位于第一个递增序列中，
                // 则将左指针移动到mid位置，重新计算mid位置
                if(numbers[left] <= numbers[mid]){
                    left = mid;
                }
                else if(numbers[mid] <= numbers[right]){
                    // 如果右指针大于中间指针的值，则mid位于第二个递增序列中
                    right = mid;
                }
            }
            return numbers[mid];
        }

        public int minOrder(int[] numbers, int left, int right){
            int result = numbers[left];
            for(int i = left + 1; i <= right; i++){
                if(numbers[i] < result){
                    result = numbers[i];
                }
            }
            return result;
        }
    }
    public int minArray1(int[] numbers) {
        // 边界条件
        if(numbers == null || numbers.length == 0)
            return 0;
        //定义头尾指针
        int left = 0;
        int right = numbers.length - 1;
        // 特殊情况：当数组有序时，需要返回第一个元素

        while(left < right){
            int mid = (left + right) / 2;
            // 情况1：numbers[mid] < numbers[right]
            if(numbers[mid] < numbers[right]){
                right = mid;
            }
            else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }
            else{
                right--;
            }
        }
        return numbers[left];
    }


    public static void main(String[] args) {
        RotatedMin rm = new RotatedMin();
        int[] nums = new int[]{3,4,5,1,2};
        int ans = rm.minArray(nums);
        System.out.println(ans);
    }
}
