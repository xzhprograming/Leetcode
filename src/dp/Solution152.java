package dp;

/**
 * @author xingzihao
 * @description
 * 152. 乘积最大子数组
 *
 *
 * 思路：
 * 定义一个最大乘积数组dp
 * 当前位置的最大乘积为Math.max（nums[i], dp[i - 1] * nums[i]）, 但是考虑到乘积的正负性问题，当前位置的最优解未必是由前一个位置的最优解转移得到的
 *
 * 考虑当前位置如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，
 * 并且我们希望这个积尽可能「负得更多」，即尽可能小。
 * 如果当前位置是一个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
 *
 * 考虑到正负性下的状态转移方程
 * maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
 * minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
 *
 *
 * @create 2025-03-15 16:35
 **/
public class Solution152 {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        // 乘积最大数组
        long[] maxF = new long[length];
        // 乘积最小数组
        long[] minF = new long[length];
        for (int i = 0; i < length; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            // 防止溢出
            if (minF[i] < (-1 << 31)) {
                minF[i] = nums[i];
            }
        }
        int ans = (int) maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, (int) maxF[i]);
        }
        return ans;
    }


    /**
     * 滚动数组
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int ans = nums[0];
        int dpMax = nums[0];
        int dpMin = nums[0];
        for(int i = 1; i < nums.length; i++){
            int max = Math.max(nums[i], Math.max(nums[i] * dpMax, nums[i] * dpMin));
            int min = Math.min(nums[i], Math.min(nums[i] * dpMax, nums[i] * dpMin));
            dpMax = max;
            dpMin = min;
            ans = Math.max(dpMax, ans);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {2,3,-2,4};
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(nums));

        System.out.println(Integer.toBinaryString(Integer.valueOf(-1 << 31)));
    }
}
