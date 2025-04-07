package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * @author xingzihao
 * @description
 *
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 思路：利用hash思想，将所有数字存入hashset中，遍历hash表中的数字，判断是否包含当前数+1，即连续序列
 * @create 2025-03-23 17:36
 **/
public class Solution128 {


    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            ForkJoinPool.commonPool();
            set.add(num);
        }

        int ans = 0;
        for(int num : set){
            // 不包含num - 1再开始计算，因为从num - 1起始的序列，一定比num起始的要长
            if(!set.contains(num - 1)){
                int curLen = 1;
                int tmp = num + 1;
                while(set.contains(tmp)){
                    curLen++;
                    tmp += 1;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {100,4,200,1,3,2};
        Solution128 solution128 = new Solution128();
        int res = solution128.longestConsecutive(nums);
        System.out.println(res);
    }
}
