package com.java.hot100;

import java.util.*;
/**
 * @className: longestConsecutive128
 * @description:
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
解题思路：
我们考虑枚举数组中的每个数 x，考虑以其为起点，不断尝试匹配 x+1, x+2,⋯ 是否存在，假设最长匹配到了 x+y，
那么以 x 为起点的最长连续序列即为 x, x+1, x+2,⋯,x+y，其长度为 y+1，我们不断枚举并更新答案即可。

我们要枚举的数 x 一定是在数组中不存在前驱数 x-1的，不然按照上面的分析我们会从 x-1开始尝试匹配，
因此我们每次在哈希表中检查是否存在 x-1 即能判断是否需要跳过了。


 * @author: xingzihao
 * @date: 2021/9/30
 **/
public class longestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        // 先去重
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        // 遍历数组
        for(int num : nums){
            if(!set.contains(num - 1)){ // 从 x-1开始尝试匹配
                int curLen = 1;
                int tmp = num;
                while(set.contains(tmp + 1)){ // 若连续，则记录其长度
                    curLen++;
                    tmp++;
                }

                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
