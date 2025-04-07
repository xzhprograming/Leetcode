package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * @create 2025-03-07 00:03
 **/
public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> ans){

        ans.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++){
            // 同一层，如果前一个数字与当前数字相同则不添加该数字
            if(i != start && nums[i - 1] == nums[i]){
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
