package greed;

/**
 * @author xingzihao
 * @description
 *55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * @create 2025-03-18 22:30
 **/
public class Solution55 {
    public boolean canJump(int[] nums) {

        // 遍历每一个数，每次都更新最大可到达的位置
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++){
            // 若当前位置可到达，则更新最大可到达位置
            if(maxReach >= i){
                maxReach = Math.max(maxReach, nums[i] + i);
                if(maxReach >= nums.length - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
