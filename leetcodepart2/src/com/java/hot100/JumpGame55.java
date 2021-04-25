package com.java.hot100;

import java.util.ArrayDeque;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 示例1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 链接：https://leetcode-cn.com/problems/jump-game
 * @author xing
 * @create 2021-04-25 20:50
 */
public class JumpGame55 {
    public boolean canJump(int[] nums) {
        // 记录可以到达的最远的位置
        int reachMax = 0;

        for(int i = 0; i < nums.length; i++){
            // 不可达
            if(i > reachMax)
                return false;
            // 更新reachMax
            reachMax = Math.max(reachMax, i + nums[i]);
        }
        return true;
    }
}
