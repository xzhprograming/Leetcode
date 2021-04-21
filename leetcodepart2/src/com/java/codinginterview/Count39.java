package com.java.codinginterview;

import java.util.*;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * @author xing
 * @create 2021-03-26 16:30
 */
public class Count39 {
    // hashmap记录
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()){
            if (map.get(key) > nums.length / 2)
                return key;
        }
        return 0;
    }
    // 摩尔投票法

    /*
    * 算法流程:
    初始化： 票数统计 votes = 0 ， 众数 x；
    循环： 遍历数组 nums 中的每个数字 num ；
    当 票数 votes 等于 0 ，则假设当前数字 num 是众数；
    当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 ；
    返回值： 返回 x 即可；
    * */
    public static int majorityElement1(int[] nums) {
        int x = 0;
        int votes = 0; // 投票
        for (int num : nums){
            // 如果当前投票为0，则设置当前下一个数字设为众数
            if (votes == 0){
                x = num;
            }
            if (x == num){
                votes++;
            }
            else{
                votes--;
            }
        }


        // 验证 x 是否为众数
        int count = 0;
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");

        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++){
            nums[i] = Integer.valueOf(split[i].replace(" ", ""));
        }
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement1(nums));
    }
}
