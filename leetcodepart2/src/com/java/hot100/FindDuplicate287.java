package com.java.hot100;

/**
 * @className: FindDuplicate287
 * @description:
 * 287. 寻找重复数
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 *
 * 解题思路：
 * 每一次猜一个数，然后 遍历整个输入数组，进而缩小搜索区间，最后确定重复的是哪个数；
 * 不是在「输入数组」上直接使用「二分查找」，而是在数组 [1, 2, ……, n] （有序数组）上使用「二分查找」。
 * @author: xingzihao
 * @date: 2021/10/23
 **/
public class FindDuplicate287 {
    public static void main(String[] args) {
        FindDuplicate287Solution1 solution1 = new FindDuplicate287Solution1();
        int[] nums = new int[]{1,3,4,2,2};
        solution1.findDuplicate(nums);
    }
}

class FindDuplicate287Solution1 {
    public int findDuplicate(int[] nums) {
        // 二分法：
        //抽屉原理:把 10 个苹果放进 9 个抽屉，一定存在某个抽屉放至少 2 个苹果
        //题意：n个整数，放在长度为 n + 1 的数组里，根据「抽屉原理」，至少会有 1 个整数是重复的
        int left = 1;
        int right = nums.length - 1;

        while(left < right){
            int mid = (left + right) / 2;
            // 计算nums数组中小于mid的数字个数
            int count = 0;
            for(int num : nums){
                if(num <= mid){
                    count++;
                }
            }

            if(count > mid){
                // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
                // 根据抽屉原理，即小于等于 mid 的个数如果严格大于 mid 个，则在[1..mid] 区间一定有一个是重复元素
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}