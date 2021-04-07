package com.java.codinginterview;

/**剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 *
 *示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 可以使用除法：
 * 求出所有数的乘积，再除以A[i]
 *
 * 不使用除法
 * 双向遍历：
 *         // 将b数组元素乘积分为两部分
 *         // A[0] * ... *A[i - 1]  和A[i + 1] * ... * A[n - 1]
 * @author xing
 * @create 2021-04-07 20:27
 */
public class ConstructArr66 {
    public int[] constructArr(int[] a) {
        // 边界条件
        if(a.length == 0 || a == null)
            return new int[0];
        int[] b = new int[a.length];
        // 将b数组元素乘积分为两部分
        // A[0] * ... *A[i - 1]  和A[i + 1] * ... * A[n - 1]
        // 双向遍历
        // 求下三角元素乘积
        int temp  = 1;
        b[0] = 1;
        for(int i = 0; i < a.length - 1; i++){
            b[i + 1] = a[i] * temp;
            temp = b[i + 1];
        }

        int tmp = 1;
        // 求上三角元素乘积
        for(int i = a.length - 2; i >= 0; i--){
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
