package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @create 2025-03-04 22:20
 **/
public class Solution46 {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            ans.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(ans, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution46 solution46 = new Solution46();
        solution46.permute(nums);
    }
}
