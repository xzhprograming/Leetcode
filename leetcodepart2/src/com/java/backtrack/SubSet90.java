package com.java.backtrack;

import java.util.*;
/**
 * @className: SubSet90
 * @description: 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * @author: xingzihao
 * @date: 2021/9/20
 **/
public class SubSet90 {
    // 使用Set去重
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, tmp);
        return new ArrayList(ans);
    }

    public void backtrack(int[] S, int start, List<Integer> tmp){

        if(start > S.length)
            return;

        ans.add(new ArrayList<Integer>(tmp));
        for(int i = start; i < S.length; i++){
            tmp.add(S[i]);
            backtrack(S, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    ArrayList<List<Integer>> ans1 = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(nums, 0, tmp);
        return ans1;
    }

    public void backtrack1(int[] S, int start, List<Integer> tmp){

        if(start > S.length)
            return;

        ans1.add(new ArrayList<Integer>(tmp));
        for(int i = start; i < S.length; i++){
            // 去重的逻辑
            // “树层去重”和“树枝去重”
            if(i > start && S[i] == S[i - 1])
                continue;
            tmp.add(S[i]);
            backtrack(S, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
