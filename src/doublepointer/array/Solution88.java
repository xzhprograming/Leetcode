package doublepointer.array;

import java.util.Arrays;

/**
 * @author xingzihao
 * @description
 * 88. 合并两个有序数组
 * @create 2025-03-23 14:43
 **/
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];

        int p1 = 0;
        int p2 = 0;
        int start = 0;
        while(p1 < m && p2 < n){
            if(nums1[p1] < nums2[p2]){
                nums[start] = nums1[p1];
                p1++;
            } else{
                nums[start] = nums2[p2];
                p2++;
            }
            start++;
        }

        while(p1 < m){
            nums[start++] = nums1[p1++];
        }

        while(p2 < n){
            nums[start++] = nums2[p2++];
        }

        nums1 = nums;
    }


    /**
     * 逆向双指针，从后向前依次取最大的，这样可以解决合并的时候覆盖的问题
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 指针设置为从后向前遍历，每次取两者之中的较大者放进 nums1 的最后面。
        int p1 = m - 1;

        int p2 = n - 1;

        int end = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[end] = nums1[p1];
                p1--;
            } else{
                nums1[end] = nums2[p2];
                p2--;
            }
            end--;
        }

        while(p1 >= 0){
            nums1[end--] = nums1[p1--];
        }

        while(p2 >= 0){
            nums1[end--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Solution88 solution88 = new Solution88();
        solution88.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
