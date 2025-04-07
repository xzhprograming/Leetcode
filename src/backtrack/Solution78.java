package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @create 2025-03-06 00:00
 **/
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int[] nums, int index, List<Integer> list, List<List<Integer>> ans){
//        start == nums.length 时，叶子节点的值会被装入 res，但 for 循环不会执行，也就结束了递归。
        ans.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
