package greed;

/**
 * @author xingzihao
 * @description
 * 45. 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 * @create 2025-03-18 23:21
 **/
public class Solution45 {


    public int jump(int[] nums) {
        // 反向查找，找出可以到达最后一个位置，并且离最后一个位置最远的位置
        int position = nums.length - 1;

        int step = 0;
        while(position > 0){
            // 找出可以到达最后一个位置，并且离最后一个位置最远的位置
            for(int i = 0; i < position; i++){
                if(i + nums[i] >= position){
                    // 更新position位置
                    position = i;
                    // 计算步数
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    public int jump1(int[] nums) {
        //正向查找

        // 跳跃步数
        int step = 0;
        // 边界位置
        int end = 0;
        // 可到达的最远位置
        int maxReach = 0;
        // 题目说所有用例均可到达，所以不需要考虑在跳最后一个位置的跳跃情况，防止多跳跃一次
        for(int i = 0; i < nums.length - 1; i++){
            maxReach = Math.max(i + nums[i], maxReach);
            if(i == end){
                end = maxReach;
                step++;
            }
        }
        return step;
    }
}
