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
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                if(nums[mid] < nums[left] && nums[mid] < nums[right]){
                    right = mid - 1;
                } else if(nums[mid] > nums[left] && nums[mid] > nums[right]){
                    left = mid + 1;
                } else{
                    left = mid + 1;
                }
            } else{
                if(nums[mid] < nums[left] && nums[mid] < nums[right]){
                    right = mid - 1;
                } else if(nums[mid] > nums[left] && nums[mid] > nums[right]){
                    left = mid + 1;
                } else{
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
