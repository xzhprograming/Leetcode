package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 * @create 2026-06-28 15:22
 **/
public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排序后，相同元素会相邻，便于同层去重；也可以在超过 target 时提前剪枝
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] candidates, int target, int start, List<List<Integer>> ans, List<Integer> tmp){
        // 剩余目标和为 0，说明当前路径中的数字之和刚好满足要求
        if(target == 0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // 从 start 开始遍历，保证每个元素在同一个组合中最多使用一次
        for(int i = start; i < candidates.length; i++){
            // 数组已排序，当前数大于 target 时，后面的数也不可能组成答案
            if(candidates[i] > target){
                break;
            }
            // 同一层中跳过重复值，避免生成相同组合
            if(i > start && candidates[i - 1] == candidates[i]){
                continue;
            }
            tmp.add(candidates[i]);
            // 组合总和 II 中每个位置只能使用一次，下一层从 i + 1 开始
            backtrack(candidates, target - candidates[i], i + 1, ans, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
