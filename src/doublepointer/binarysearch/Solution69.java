package doublepointer.binarysearch;

/**
 * @author xingzihao
 * @description 69. x 的平方根
 *
 * 给定非负整数 x，计算并返回 x 的算术平方根。
 *
 * 由于返回类型是整数，结果只保留整数部分，小数部分舍去。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 思路：
 * 在 [0, x] 中二分查找最大的整数 ans，使得 ans * ans <= x。
 * 为避免 mid * mid 在 int 范围内溢出，乘积使用 long 保存。
 * @create 2026-06-22 00:40
 **/
public class Solution69 {
    /**
     * 二分查找平方不超过 x 的最大整数。
     *
     * @param x 非负整数
     * @return x 的算术平方根整数部分
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long num = (long) mid * mid;
            if (num <= x) {
                // mid 是一个可行答案，继续向右查找更大的可行值。
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
