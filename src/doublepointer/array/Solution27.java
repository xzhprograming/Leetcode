package doublepointer.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author xingzihao
 * @description
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * 解题思路：
 * 快慢指针：定义slow和fast指针，fast先行，找到不为val的元素，将fast指向元素赋给slow, slow前进，则slow的最终值即为k
 * @create 2025-01-19 15:27
 **/
class Solution27 {

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;

        int size = nums.length;
        while(fast < size){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        Solution27 solution27 = new Solution27();
        int k = solution27.removeElement(nums, 3);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
