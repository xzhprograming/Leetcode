package com.java.codinginterview;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 *一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *     // 解题思路
 *     // 找出只出现一次的一个数字，所有数字异或即可得到只出现一次的数
 *     // 异或^: 相同为0，不同为1
 *
 *     // 找出两个只出现一次的数字
 *     // 设这两个数为x ,y
 *     // 所有数字异或，则最终值为x ^ y
 *
 *     // 我们只需将数组进行分组，分为A和B
 *     // 其中A包含x和相同的数
 *     // B包含y和相同的数
 * //    如果我们可以把所有数字分成两组，使得：
 *
 * // 两个只出现一次的数字在不同的组中；
 *
 * // 相同的数字会被分到相同的组中。
 *如何实现这样的分组？？？？？
 *1. 两个只出现一次的数字在不同的组中；
 * 2. 相同的数字会被分到相同的组中。
 *
 *     // 利用x和y的第一位不相同的位进行划分
 *     // 相同的数必然被分到同一组
 *     //x和y在此位上异或不同所以结果才为1，使用此位 x和y也必然分配到不同的组
 *
 * @author xing
 * @create 2021-04-02 17:06
 */
public class CountNum {
    public int[] singleNumbers(int[] nums) {
        int m = 1;
        int res = 0;
        // 所有数字异或，则最终值为x ^ y
        for(int num : nums){
            res ^= num;
        }
        // 找到x和y的第一位不相同的位
        while((res & m) == 0)
            m <<= 1;
        int x =0, y = 0;
        // 利用x和y的第一位不相同的位进行划分
        for(int num : nums){
            if((num & m) == 0)
                x ^= num;
            else
                y ^= num;
        }
        return new int[]{x, y};
    }
}
