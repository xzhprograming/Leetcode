package com.java.codinginterview;

/**剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 解题思路：
 * 归并排序中对数组中的逆序数进行统计
 *
 * @author xing
 * @create 2021-04-09 23:04
 */
public class ReversePairs51 {
    int[] temp;
    int count;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right){
        // 终止条件
        if(left >= right)
            return;

        int mid = (left + right) >> 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 合并两个有序的数组
        int pleft = left;
        int pright = mid + 1;
        int index = 0;
        while(pleft <= mid && pright <= right){
            if(nums[pleft++] <= nums[pright++])
                temp[index++] = nums[pleft];
            else{
//                1、6、7、8         2、3、4、5
//                我们此时 temp1 指向元素为 6，temp2 指向元素为 2, nums[temp1] > nums[temp2]，
//                则此时我们需要将 temp2 指向的元素存入临时数组中，又因为每个小集合中的元素都是有序的，
//                所以 temp1 后面的元素也一定大于 2，那么我们就可以根据 temp1 的索引得出逆序对中包含 2 的逆序对个数，则是 mid - temp + 1。
                count += mid - pleft + 1;
                temp[index++] = nums[pright];
            }
        }
        // 判断哪个数组非空
        while(pleft <= mid){
            temp[index++] = nums[pleft];
        }

        while(pright <= right){
            temp[index++] = nums[pright];
        }

        // 赋值
        for(int i = 0; i < right - left + 1; i++)
            nums[left + i] = temp[i];
    }
}
