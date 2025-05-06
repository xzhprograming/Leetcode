import java.util.HashMap;
import java.util.Map;

/**
 * @author xingzihao
 * @description
 * 560.和为 K 的子数组
 *给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 思路：
 * 使用前缀和的方法可以解决这个问题，因为我们需要找到和为k的连续子数组的个数。通过计算前缀和，我们可以将问题转化为求解两个前缀和之差等于k的情况。
 *
 * 假设数组的前缀和数组为prefixSum，其中prefixSum[i]表示从数组起始位置到第i个位置的元素之和。那么对于任意的两个下标i和j（i < j），
 * 如果prefixSum[j] - prefixSum[i] = k，即从第i个位置到第j个位置的元素之和等于k，那么说明从第i+1个位置到第j个位置的连续子数组的和为k。
 *
 * 通过遍历数组，计算每个位置的前缀和，并使用一个哈希表来存储每个前缀和出现的次数。在遍历的过程中，我们检查是否存在prefixSum[j] - k的前缀和，
 * 如果存在，说明从某个位置到当前位置的连续子数组的和为k，我们将对应的次数累加到结果中。
 *
 * 这样，通过遍历一次数组，我们可以统计出和为k的连续子数组的个数，并且时间复杂度为O(n)，其中n为数组的长度。
 *
 * 问：为什么这题不适合用滑动窗口做？
 *
 * 答：滑动窗口需要满足单调性，当右端点元素进入窗口时，窗口元素和是不能减少的。本题 nums 包含负数，当负数进入窗口时，窗口左端点反而要向左移动，导致算法复杂度不是线性的。
 *
 * @create 2025-05-06 23:26
 **/
public class Solution560 {


    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 初始化前缀和为0的次数为1，对应prefixSum[j] - k = 0的情况，则次数记录为1

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 统计和为k的次数
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 记录前缀和，和其出现的次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
