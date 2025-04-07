package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 * 思路：
 * 1.跟全排列问题的思想基本相同，采用回溯的方法穷举所有排列情况，做出元素选择，通过元素是否使用过标记做剪枝，并向上回溯撤销选择，直到回溯到初始状态。
 * 2. 剪枝1：位置去重，如果当前元素使用过则不再继续使用
 * 3. 剪枝2：相同元素得到的排列结果是相同的，如果前一个元素和当前元素相等，并且前一个元素未被使用过，则说明该元素已经在前一个元素拿到了全排列的结果，则当前元素不用再继续获取排列结果了
 * 4. 实现前提：需要先将原数组排序，使数字相同的在相邻位置
 *
 * 举例说明：
 * /当出现重复元素时，比如输入 nums = [1,2,2',2'']，2' 只有在 2 已经被使用的情况下才会被选择，同理，2'' 只有在
 * //2' 已经被使用的情况下才会被选择，这就保证了相同元素在排列中的相对位置保证固定。
 * @create 2025-03-09 13:42
 **/
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // 需要先将原数组排序，使数字相同的在相邻位置
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), ans, used);
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] used){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // 位置去重，如果当前元素使用过则不再继续使用
            if(used[i]){
                continue;
            }
            // 如果前一个元素和当前元素相等，并且前一个元素未被使用过，
            // 则说明该元素已经在前一个元素拿到了全排列的结果，则当前元素不用再继续获取了
            if(i > 0 && nums[i - 1] == nums[i] && !used[i - 1]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums, list, ans, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }

    }
}
