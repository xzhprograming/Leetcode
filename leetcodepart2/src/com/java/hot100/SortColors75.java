package com.java.hot100;

/**
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 解题思路；
 * 1. 统计0,1,2的个数，然后按照个数更新nums数组
 * <p>
 * 2. 单指针
 * 遍历两次数组，第一次将0交换到最前面，第二次将1交换到最前面
 * <p>
 * 3. 双指针
 * 定义p0, p1指针
 * 情况1：如果找到了 1，那么将其与nums[p1]进行交换，并将 p1向后移动一个位置
 * 情况2：如果找到了 0，那么将其与nums[p0]进行交换，并将 p0向后移动一个位置
 * 如果p0 < p1，那么p0与其交换位置之后，还要与p1进行交换（因为如果p0 < p1，那么一定有1已经被交换到头部了，此时一定会把一个 1交换出去）
 * 无论是否有p0 < p1, p0和p1均向后移动一个位置（因为p0位置被交换后必为0，所以遇到p1也不用交换，所以p0和p1同时前进一步）
 *
 * @author xing
 * @create 2021-05-02 23:06
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        // 定义双指针
        int p0 = 0;
        int p1 = 0;

        // 对p0， p1位置与nums进行交换
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1)
                    swap(nums, i, p1);
                p0++;
                p1++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
