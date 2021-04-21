package com.java.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * 回溯法
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @author xing
 * @create 2021-03-20 20:28
 */
public class Permutations {
    List<List<Integer>> result = new ArrayList<>(); //记录最终结果

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();// 记录「路径」
        backtrack(nums, temp);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> temp){
        // 触发结束条件
        if(temp.size() == nums.length){
            List<Integer> temp1 = new ArrayList(temp);
            result.add(temp1);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // 如果数组中已包含当前数字,排除不合法的选择
            if(temp.contains(nums[i]))
                continue;
            // 做选择
            temp.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, temp);
            // 取消选择
            temp.remove(temp.size() - 1);
        }
    }

    public void test(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        temp.add(1);
        temp.add(1);
//        result.add(new ArrayList(temp));
        result.add(temp);
        temp.remove(1);
        System.out.println(temp);
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permutations p = new Permutations();
        List<List<Integer>> ans = p.permute(nums);
        System.out.println(ans);
    }
}
