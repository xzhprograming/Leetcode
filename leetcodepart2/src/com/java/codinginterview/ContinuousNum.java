package com.java.codinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * @author xing
 * @create 2021-04-02 21:21
 */
public class ContinuousNum {
    public int[][] findContinuousSequence(int target) {
        // 上限最大数为target / 2
        // 因为target / 2 + (target / 2 + 1) > target
        List<int[]> list = new ArrayList<>();
        // 定义双指针
        int left = 1;
        int right = 1;
        int boundary = target / 2;
        int sum = 0;
        while(left <= boundary){
            // 如果和相等,记录当前结果，
            if (sum == target){
                int[] ans = new int[right - left];
                for (int i = left; i < right; i++){
                    ans[i - left] = i;
                }
                list.add(ans);
                sum -= left;
                left++;
            }
            // 如果sum < target, right右移
            else if(sum < target){
                sum += right; // 更新sum
                right++;
            }
            //如果sum > target, left右移
            else{
                sum -= left; // 更新sum
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        ContinuousNum cn = new ContinuousNum();
        int[][] ans = cn.findContinuousSequence(9);
        System.out.println(Arrays.deepToString(ans));
    }
}
