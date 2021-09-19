package com.java.backtrack;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * @author xing
 * @create 2021-09-19 22:22
 */
public class Permutations47 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int start){
        // 递归终止条件
        if(start == nums.length - 1){
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                tmp.add(nums[i]);
            }
            ans.add(tmp);
            return;
        }

        //固定第一位，求剩下数字的排列，对剩下的数字采取同样的方式求其排列
        // 然后用后面的每一位与第一位进行交换，求出所有排列
        // 去重：若同一位上可能出现相同的数字，则需要去重
        Set<Integer> set = new HashSet<>();
        for(int i = start; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            // 做出选择
            swap(nums, i, start);
            // 开启下层递归： 调用 dfs(x + 1) ，即开始固定第 start + 1 个字符；
            dfs(nums, start + 1);
            // 撤销选择
            swap(nums, i, start);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
