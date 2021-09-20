package com.java.hot100;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * // 计算当前位置可解雨水的高度：Math.min(左边柱子的最大高度， 右边柱子的最大高度) - height[当前位置]
 * @author xing
 * @create 2021-04-24 20:48
 */
public class TrapRainWater42 {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;

        // 双指针记录左边和右边的最大值
        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length - 1;

        int ans = 0;
        while(left < right){
            // 更新左右最大值
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if(height[left] < height[right]){
                // 则必有leftMax < rightMax
                ans += leftMax - height[left];
                left++;
            }
            else{
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
