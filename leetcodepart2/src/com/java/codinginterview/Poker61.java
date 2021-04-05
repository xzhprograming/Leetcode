package com.java.codinginterview;

import java.util.Arrays;

/**
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * @author xing
 * @create 2021-04-05 23:26
 */
public class Poker61 {
    public boolean isStraight(int[] nums) {
        // 边界条件
        // 三种情况：
        // 0的个数为0、1、2
        // 将数组排序
        Arrays.sort(nums);
        // 统计0的个数
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }
        }

        // 遍历数组中的非0元素，统计空缺的值
        int gap = 0;
        int small = count;
        for(int i = small; i < nums.length - 1; i++){
            // 若有重复的牌出现
            if(nums[i + 1] - nums[i] == 0)
                return false;
            gap += nums[i + 1] - nums[i] - 1;
        }
        //如果空缺值大于0的个数，则不连续
        if(gap > count)
            return false;
        return true;
    }
}

class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}

