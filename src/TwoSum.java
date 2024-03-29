/*
 * 1. Two Sum
 * 题意：返回数组中和为给定数的下标
 * 难度：Easy
 * 分类：Array, HashTable
 * 算法：题目说明了数组中一定有解，且解唯一，所以用哈希表记录已遍历的元素即可
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] test = new int[]{2, 7, 11, 15};
        int[] ans1 = twoSum1(test, 9);
        int[] ans2 = twoSum1(test, 9);
        System.out.println(Arrays.toString(ans1));
        System.out.println(Arrays.toString(ans2));
    }

    public static int[] twoSum1(int[] nums, int target) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
