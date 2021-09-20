package com.java.backtrack;

import java.util.*;

/**
 * @className: SubSet78
 * @description:
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * @author: xingzihao
 * @date: 2021/9/20
 **/
public class SubSet78 {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, 0, tmp);
        return ans;
    }

    public void backtrack(int[] S, int start, List<Integer> tmp){

        if(start > S.length)
            return;

        ans.add(new ArrayList<Integer>(tmp));
        for(int i = start; i < S.length; i++){
            // 去除重复元素
            if(tmp.contains(S[i]))
                continue;
            tmp.add(S[i]);
            backtrack(S, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
