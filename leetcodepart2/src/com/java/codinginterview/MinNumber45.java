package com.java.codinginterview;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 *
 *
 * @author xing
 * @create 2021-03-30 16:31
 */
public class MinNumber45 {
    // 解题思路：
    // 按照某种特殊方式对数组进行排序
    // 若 x + y > y + x, x > y
    // 若 x + y > y + x, x < y
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public void quickSort(String[] strs, int start, int end){
        if (start >= end)
            return;
        int index = partition(strs, start, end);
        quickSort(strs, start, index - 1);
        quickSort(strs, index + 1, end);
    }

    public int partition(String[] strs, int start, int end){
        //  随机选取一个位置，将小于此元素的放在左边，大于此元素的放在右边
        int index = start;
        // 将选中的元素放在最后一位
        swap(strs, index, end);
        // 记录小于index元素的位置
        int small = start;
        for (int i = start; i < end; i++){
            String tmp1 = strs[i] + strs[end];
            String tmp2 = strs[end] + strs[i];
            if (tmp1.length() < tmp2.length()){
                swap(strs, i, small);
                small++;
            }
            if (tmp1.length() == tmp2.length() && tmp1.compareTo(tmp2) < 0)
            {
                swap(strs, i, small);
                small++;
            }
        }
        swap(strs, small, end);
        return small;
    }

    public void swap(String[] strs, int i, int j){
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
    public String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        MinNumber45 mn = new MinNumber45();
        System.out.println(mn.minNumber(nums));
        String s1 = "123";
        String s2 = "1234";
        System.out.println(s1.compareTo(s2));
    }
}
