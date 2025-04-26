package array;

/**
 * @author xingzihao
 * @description
 * 169. 多数元素
 *给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 思路：
 * 1. Hash表，遍历数组 nums ，用 HashMap 统计各数字的数量，即可找出 众数
 * 2. 排序后，中点位置即为要求的元素
 * 3.摩尔投票，核心理念为 票数正负抵消
 * 推论一： 若记 众数 的票数为 +1 ，非众数 的票数为 −1 ，则一定有所有数字的 票数和 >0 。
 * 推论二： 若数组的前 a 个数字的 票数和 =0 ，则 数组剩余 (n−a) 个数字的 票数和一定仍 >0 ，即后 (n−a) 个数字的 众数仍为 x 。
 *
 * 算法流程:
 * 初始化： 票数统计 votes = 0 ， 众数 x。
 * 循环： 遍历数组 nums 中的每个数字 num 。
 * 当 票数 votes 等于 0 ，则假设当前数字 num 是众数。
 * 当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 。
 * 返回值： 返回 x 即可。
 *
 * @create 2025-04-20 12:54
 **/
public class Solution169 {

    public int majorityElement(int[] nums) {

        if(nums==null||nums.length==0){
            return 0;
        }
        int vote = 0;
        int res = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(vote == 0){
                res = nums[i];
            }
            vote += nums[i] == res ? 1 : -1;
        }

        // 验证res是否为众数
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == res){
                count++;
            }
        }
        return count >= nums.length / 2 ? res : 0;
    }

}
