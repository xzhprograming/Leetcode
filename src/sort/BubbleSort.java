package sort;

import java.util.Arrays;

/**
 * @author xingzihao
 * @description
 * @create 2025-03-09 13:47
 **/
public class BubbleSort {

    public void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = nums.length - 1; j > i; j--){
                if(nums[j] < nums[j - 1]){
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    /**
     * 元素交换
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5,12,51};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
