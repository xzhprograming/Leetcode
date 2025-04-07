package doublepointer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 思路：
 * 1.三数之和转换为求两数之和的问题
 * 2.将数组排序，并转换为求两数之和的问题，利用双指针解决
 * 3.结果去重，在target相同时要去重，在求两数之和的时候也要去重
 * @create 2025-03-22 15:34
 **/
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i <= nums.length - 3; i++){
            // 过滤掉重复结果
            // 一定校验前一位是否等于当前位置，否则会漏解
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            List<List<Integer>> tmp = twoSum(nums, i + 1, nums.length - 1, target, nums[i]);
            ans.addAll(tmp);
        }
        return ans;
    }

    public List<List<Integer>> twoSum(int[] numbers, int start, int end, int target, int cur) {
        // 2,3,4,7  target=7
        int low = start;
        int high = end;

        List<List<Integer>> ans = new ArrayList<>();

        while(low < high){
            int sum = numbers[low] + numbers[high];

            if(sum == target){
                ans.add(Arrays.asList(numbers[low], numbers[high], cur));
                // 跳过重复元素
                int tmp = numbers[low];
                while(low < high && tmp == numbers[low]){
                    low++;
                }
            } else if(sum < target){
                low++;
            } else{
                high--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> lists = new Solution15().threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
