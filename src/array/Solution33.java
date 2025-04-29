package array;

/**
 * @author xingzihao
 * @description
 * 33. 搜索旋转排序数组
 *
 * @create 2025-04-25 00:06
 **/
public class Solution33 {

    public int search(int[] nums, int target) {
        // 利用旋转数组的局部有序性进行二分查找
        // 情况1：nums[mid] < target <= nums[len-1]
        // 情况2：nums[0] <= nums[mid] : nums[0] <= target < nums[mid]

        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int search = new Solution33().search(new int[]{3,1}, 1);
        System.out.println(search);
    }
}
