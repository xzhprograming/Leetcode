package prefixsum;

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

    /**
     * 解法一：暴力枚举（最容易理解，但效率低）
     * 枚举所有可能的子数组，计算它们的和
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        // 枚举所有子数组 [i, j]
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                // 如果子数组 [i, j] 的和等于 k，计数加1
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 解法二：前缀和数组 + HashMap（推荐，清晰易懂）
     *
     * 核心思想：
     * 1. 先计算前缀和数组 prefixSum
     * 2. 对于每个位置 j，查找是否有 prefixSum[i] = prefixSum[j] - k
     * 3. 用 HashMap 记录每个前缀和出现的次数
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int subarraySumPrefixArray(int[] nums, int k) {
        int n = nums.length;

        // 步骤1：构建前缀和数组
        // prefixSum[i] 表示 nums[0...i-1] 的和
        // prefixSum[0] = 0（空前缀）
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // 步骤2：使用 HashMap 统计
        // key: 前缀和的值
        // value: 该前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;

        // 遍历每个位置 j
        for (int j = 1; j <= n; j++) {
            // 我们需要找到 i < j，使得 prefixSum[j] - prefixSum[i] = k
            // 即 prefixSum[i] = prefixSum[j] - k
            int target = prefixSum[j] - k;

            // 如果找到了这样的前缀和，累加它的出现次数
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            // 将当前前缀和加入 HashMap
            map.put(prefixSum[j], map.getOrDefault(prefixSum[j], 0) + 1);
        }

        return count;
    }

    /**
     * 解法三：优化空间的前缀和（最优解，原题解法）
     *
     * 优化点：
     * 不需要显式构建前缀和数组，用一个变量 sum 动态维护即可
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) - HashMap 的空间
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // 初始化：前缀和为 0 出现了 1 次
        // 这是为了处理从数组开头开始的子数组
        // 例如：nums = [2, 3], k = 5
        // 当 sum = 5 时，target = 5 - 5 = 0，需要 map 中有 {0: 1}
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            // 累加当前元素，得到当前位置的前缀和
            sum += nums[i];

            // 查找是否存在前缀和等于 sum - k
            // 如果存在，说明从那个位置之后到当前位置的子数组和为 k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // 将当前前缀和加入 HashMap
            // 如果已经存在，次数 +1；否则初始化为 1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // 测试用例1
        int[] nums1 = {1, 1, 1};
        int k1 = 1;
        System.out.println("测试用例1:");
        System.out.println("暴力解法: " + subarraySumBruteForce(nums1, k1));
        System.out.println("前缀和数组: " + subarraySumPrefixArray(nums1, k1));
        System.out.println("优化解法: " + subarraySum(nums1, k1));
        // 期望输出: 2

        // 测试用例2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("\n测试用例2:");
        System.out.println("暴力解法: " + subarraySumBruteForce(nums2, k2));
        System.out.println("前缀和数组: " + subarraySumPrefixArray(nums2, k2));
        System.out.println("优化解法: " + subarraySum(nums2, k2));
        // 期望输出: 2

        // 测试用例3：包含负数
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("\n测试用例3（包含负数）:");
        System.out.println("暴力解法: " + subarraySumBruteForce(nums3, k3));
        System.out.println("前缀和数组: " + subarraySumPrefixArray(nums3, k3));
        System.out.println("优化解法: " + subarraySum(nums3, k3));
        // 期望输出: 3

        // 测试用例4：从开头开始的子数组
        int[] nums4 = {2, 3};
        int k4 = 5;
        System.out.println("\n测试用例4（从开头开始）:");
        System.out.println("暴力解法: " + subarraySumBruteForce(nums4, k4));
        System.out.println("前缀和数组: " + subarraySumPrefixArray(nums4, k4));
        System.out.println("优化解法: " + subarraySum(nums4, k4));
        // 期望输出: 1
    }
}

