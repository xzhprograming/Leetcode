package doublepointer.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xingzihao
 * @description
 * 283.移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 解题思路：
 * 快慢指针：fast找到不为0的元素，将不为0的元素控制在[0...slow]中，最后再将尾部的元素置为零
 * @create 2025-01-19 19:23
 **/
class Solution283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        int size = nums.length;
        while(fast < size){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while(slow < size){
            nums[slow++] = 0;
        }
    }

    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();
        int[] nums = new int[]{0,1,0,3,12};
        Solution283 solution283 = new Solution283();
        solution283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}