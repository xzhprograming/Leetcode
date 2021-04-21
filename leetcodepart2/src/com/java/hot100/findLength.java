package com.java.hot100;

/**718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * @author xing
 * @create 2021-04-19 21:45
 */
public class findLength {

}

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;

        int n1 = nums1.length;
        int n2 = nums2.length;

        // 分别遍历两个数组
        for(int i = 0; i < nums1.length; i++){
            int len = Math.min(n2, n1 - i);

            int tmp = compareLen(nums1, nums2, i, len);
            max = Math.max(max, tmp);
        }

        for(int i = 0; i < nums2.length; i++){
            int len = Math.min(n1, n2 - i);

            int tmp = compareLen(nums2, nums1, i, len);
            max = Math.max(max, tmp);
        }
        return max;
    }

    public int compareLen(int[] nums1, int[] nums2, int start, int len){
        int ret = 0;
        int tmp = 0;
        for(int i = 0; i < len; i++){
            if(nums1[i + start] == nums2[i]){
                tmp++;
            }
            else{
                tmp = 0;
            }
            ret = Math.max(ret, tmp);
        }
        return ret;
    }
}
