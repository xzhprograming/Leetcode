
/*
给定一个包n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，
使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
因为规定只存在唯一答案，因此给定的数组中必没有重复元素，否则就不唯一了。因此可省去除重复元素的操作。
示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 100000;
        int n = nums.length;
        //对数组进行排序
        Arrays.sort(nums);
        // 遍历数组找到first + second + third之和最接近target的sum
        for(int first = 0; first < n; first++){
            int third = n - 1;
            int second = first + 1;
            while (second < third){
                int sum = nums[first] + nums[second]+ nums[third];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值更新答案,即拿上一次的结果与新的结果进行比较
                if (Math.abs(sum -target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if (sum > target){
                    third--;
                }
                if (sum < target)
                    second++;
            }
        }
        return ans;
    }
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            // 根据条件判断是左指针移动还是右指针移动，对于判断条件后两个指针都可能进行移动尽量使用while
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

/*
* 复杂度分析

时间复杂度：O(N^2)，其中 N 是数组nums 的长度。我们首先需要O(NlogN) 的时间对数组进行排序，随后在枚举的过程中，使用一重循环 O(N) 枚举 a，双指针O(N) 枚举 b 和 c，故一共是 O(N^2)。

空间复杂度：O(logN)。排序需要使用O(logN) 的空间。然而我们修改了输入的数组nums，在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了nums 的副本并进行排序，此时空间复杂度为O(N)。
。*/
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
