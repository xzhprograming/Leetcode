package com.java.hot100;

/**11. 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * @author xing
 * @create 2021-04-23 20:43
 */
public class MaxArea11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = 0;
        int ans = 0;

        while(left < right){
            area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(area, ans);
            if(height[left] <= height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxArea11 ma = new MaxArea11();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(ma.maxArea(height));
    }
}
