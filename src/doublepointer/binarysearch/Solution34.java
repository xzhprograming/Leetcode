package doublepointer.binarysearch;

/**
 * @author xingzihao
 * @description
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @create 2026-05-05 21:50
 **/
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        // 找左边界
        int left = findLeftBound(nums, target);
        // 找右边界
        int right = findRightBound(nums, target);
        return new int[]{left, right};
    }
    public int findLeftBound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int index = left + (right - left) / 2;
            if(nums[index] == target){
                right = index - 1;
            } else if(nums[index] < target){
                left = index + 1;
            } else{
                right = index - 1;
            }
        }
        if(left < 0 || left >= nums.length){
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public int findRightBound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int index = left + (right - left) / 2;
            if(nums[index] == target){
                left = index + 1;
            } else if(nums[index] < target){
                left = index + 1;
            } else{
                right = index - 1;
            }
        }
        if(right < 0 || right > nums.length){
            return -1;
        }
        return nums[right] == target ? right : -1;
    }}
