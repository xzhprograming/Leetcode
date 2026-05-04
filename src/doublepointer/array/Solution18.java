package doublepointer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 解题思路：排序 + 双指针
 *
 * 1. 排序：首先对数组进行排序，为双指针和剪枝做准备
 *
 * 2. 固定两个数 + 双指针找另外两个数：
 *    - 外层循环固定第一个数 nums[i]
 *    - 内层循环固定第二个数 nums[j]
 *    - 使用双指针 left 和 right 在剩余区间找满足条件的两个数
 *
 * 3. 去重处理：
 *    - i 去重：如果 nums[i] == nums[i-1]，跳过避免重复四元组
 *    - j 去重：如果 nums[j] == nums[j-1]，跳过避免重复四元组
 *    - left 去重：找到目标后，跳过所有相同的 nums[left]
 *
 * 4. 剪枝优化：
 *    - 最小值剪枝：当前组合的最小可能和 > target，后续无需继续 (break)
 *    - 最大值剪枝：当前组合的最大可能和 < target，跳过当前 i/j (continue)
 *
 * 5. 注意事项：
 *    - 使用 long 防止四数相加溢出
 *    - 结果顺序：代码中为 [left, right, i, j]，可按需调整
 *
 * 时间复杂度：O(n^3) - 三层循环
 * 空间复杂度：O(log n) - 排序空间
 *
 * @author xingzihao
 * @create 2026-05-04 17:12
 **/
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序 + 双指针
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i <= n - 4; i++){
            // 结果去重
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 剪枝优化
            if((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }
            if((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target){
                continue;
            }
            for(int j = i + 1; j <= n - 3; j++){
                // 结果去重
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                // 剪枝优化
                if((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    break;
                }
                if((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target){
                    continue;
                }
                // 转换为两数之和
                int left = j + 1;
                int right = n - 1;
                while(left < right){
                    long fourSumRes = (long) nums[left] + nums[right] + nums[i] + nums[j];
                    if(fourSumRes == target){
                        ans.add(Arrays.asList(nums[left], nums[right], nums[i], nums[j]));
                        // 指针移动 + 去重
                        int leftVal = nums[left];
                        while(left < right && nums[left] == leftVal){
                            left++;
                        }
                    } else if(fourSumRes < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        System.out.println(new Solution18().fourSum(nums, 0));
    }
}
