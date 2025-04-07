package doublepointer.array;

import java.util.Arrays;

/**
 * @author xingzihao
 * @description
 * 167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * @create 2025-03-22 14:52
 **/
public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0){
            return new int[0];
        }
        // 2,3,4,7  target=7
        int low = 0;
        int high = numbers.length - 1;
        int n = numbers.length;

        while(low < high){
            int sum = numbers[low] + numbers[high];

            if(sum == target){
                return new int[]{low + 1, high + 1};
            } else if(sum < target){
                low++;
            } else{
                high--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {

        int[] nums = {3,24,50,79,88,150,345};
        int target = 200;
        Solution167 solution167 = new Solution167();
        int[] res = solution167.twoSum(nums, target);
        System.out.println(res);
    }
}
