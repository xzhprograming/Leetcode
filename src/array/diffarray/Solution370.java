package array.diffarray;

/**
 * @author xingzihao
 * @description
 * 370.区间加法
 * 题意：
 * 给定一个长度为 n、初始全为 0 的数组
 * 每次允许你对某个区间 [i, j] 的所有元素加上 x
 * 执行一系列操作后，返回整个数组的值
 *
 * 这是一个经典的差分数组应用题。主要思路是：
 * 构造差分数组 diff，其中 diff[i] = nums[i] - nums[i-1]
 * 区间修改优化：对区间 [i, j] 增加 value 时：
 * diff[i] += value
 * diff[j+1] -= value（如果 j+1 在范围内）
 * 还原结果数组：通过差分数组求前缀和得到最终结果
 * result[0] = diff[0]
 * result[i] = result[i-1] + diff[i]
 * 这种方法的优势是将区间修改的时间复杂度从 O(n) 降低到 O(1)，最后通过一次遍历还原数组即可。
 *
 * @create 2026-04-06 20:28
 **/
public class Solution370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];
        // 构造差分解法
        Difference df = new Difference(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }
        return df.result();
    }

}

class Difference {
    // 差分数组
    private int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        // 构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 给闭区间 [i, j] 增加 val（可以是负数）
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
