package com.java.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**39. 组合总和
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 *
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 *
 * 解题思路：
 *
 * @author xing
 * @create 2021-04-03 16:36
 */
public class CombinationSum39 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 边界条件
        if(candidates == null || candidates.length == 0)
            return ans;
        List<Integer> temp = new ArrayList<>();
        backtrack(candidates, target, temp);
        return ans;
    }

    public void backtrack(int[] candidates, int target, List<Integer> temp){
        // 求temp中数的和
        int sum = 0;
        for(int i = 0; i < temp.size(); i++){
            sum += temp.get(i);
        }
        // 若当前数组等于target
        if(sum == target){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++){
                list.add(temp.get(i));
            }
            list.sort((o1, o2) -> o1.compareTo(o2));
            if (!ans.contains(list))
                ans.add(new ArrayList(list));
            return;
        }
        // 若当前数组和大于target，因为数组中元素都为正整数，再递进下去则无解，所以终止
        if (sum > target)
            return;

        for(int i = 0; i < candidates.length; i++){
            temp.add(candidates[i]);
            backtrack(candidates, target, temp);
            temp.remove(temp.size() - 1);
        }
    }


    // 回溯加剪枝
    //
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        // 边界条件
        List<List<Integer>> ans1 = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return ans1;
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, ans1);
        return ans1;
    }

    public void dfs(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> ans1){
        // 终止条件
        if(target < 0)
            return;
        if(target == 0){
            ans1.add(new ArrayList<Integer>(path));
            return;
        }
//        按某种顺序搜索
//        从每一层的第 2 个结点开始，都不能再搜索产生同一层结点已经使用过的 candidate 里的元素。
//        从start开始
        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            dfs(candidates, i, target - candidates[i], path, ans1);
            path.remove(path.size() - 1);
            System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        CombinationSum39 cs = new CombinationSum39();
        int[] nums = new int[]{2,3,6,7};
        System.out.println(cs.combinationSum1(nums, 7));
        List<List<int[]>> list = new ArrayList<>();
        List<int[]> list1 = new ArrayList<>();
        list1.add(nums);
        list.add(list1);
        for (int i = 0; i < list.size(); i++){
            List<int[]> temp = list.get(i);
            for (int j = 0; j < temp.size(); j++){
                int[] tmpInt = temp.get(j);
                System.out.println(Arrays.toString(tmpInt));
            }
        }
//        System.out.println(list);
    }
}
