package monotonicstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author xingzihao
 * @description
 *
 * 496. 下一个更大元素
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 *
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 *
 *
 * 思路：
 * 倒序遍历nums2， 并用单调栈中维护当前位置右边的更大的元素列表，从栈底到栈顶的元素是单调递减的。
 * @create 2025-02-18 22:22
 **/
public class Solution496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = findNextMinItemMap(nums2);
        System.out.println(map);
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public Map<Integer, Integer> findNextMaxItemMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            int nextItem = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums[i], nextItem);
            stack.push(nums[i]);
        }
        return map;

    }

    /**
     * 找到下一个最小元素
     * @param nums
     * @return
     */
    public Map<Integer, Integer> findNextMinItemMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() >= nums[i]){
                stack.pop();
            }
            int nextItem = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums[i], nextItem);
            stack.push(nums[i]);
        }
        return map;

    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {2,5,7,6,8,4,1};
        Solution496 solution496 = new Solution496();
        int[] res = solution496.nextGreaterElement(nums1, nums2);
        System.out.println(res);
    }

}
