package sort;

/**
 * @author xingzihao
 * @description
 * 归并排序
 * @create 2025-05-06 23:05
 **/
public class MergeSort {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int[] ans = new int[end - start + 1];
        int left = start;
        int right = mid + 1;

        int begin = 0;
        while(left <= mid && right <= end){
            if(nums[left] < nums[right]){
                ans[begin++] = nums[left++];
            } else {
                ans[begin++] = nums[right++];
            }
        }

        while(left <= mid){
            ans[begin++] = nums[left++];
        }

        while(right <= end){
            ans[begin++] = nums[right++];
        }

        for(int i = 0; i < ans.length; i++){
            nums[i + start] = ans[i];
        }
    }
}
