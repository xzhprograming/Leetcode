package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 思路：
 * 1. 组合问题，实际上也是子集问题：candidates 的哪些子集的和为 target？
 * 想解决这种类型的问题，也得回到回溯树上，我们不妨先思考思考，标准的子集/组合问题是如何保证不重复使用元素的？
 * // 无重组合的回溯算法框架
 * void backtrack(int[] nums, int start) {
 *     for (int i = start; i < nums.length; i++) {
 *         // ...
 *         // 递归遍历下一层回溯树，注意参数
 *         backtrack(nums, i + 1);
 *         // ...
 *     }
 * }
 * 2.想让每个元素被重复使用，我只要把 i + 1 改成 i 即可：
 * @create 2025-03-09 14:52
 **/
public class Solution39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] candidates, int start, int target, List<List<Integer>> ans, List<Integer> list){
        if(target < 0){
            return;
        }

        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        // 类似于子集问题，但是想让每个元素被重复使用，只要把 i + 1 改成 i 即可
        // 举例：candidates= [2,3,6,7]， target = 7
        // 那么[2,2,3], [2,3,2],[3,2,2]都满足条件，但是其都符合同一个子集的条件
        // 可以看如果2已经被使用了，那么后序的结果中，不应该再包含这个元素了，因为包含该元素的子集，在2为固定位的时候已经被找到了
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], ans, list);
            list.remove(list.size() - 1);
        }
    }
}
