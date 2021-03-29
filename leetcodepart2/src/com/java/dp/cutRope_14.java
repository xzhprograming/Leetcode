package com.java.dp;

import java.util.Scanner;

/**
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

 * 解法一：数学方法
 * 设将长度为 n 的绳子切为 a 段：则 n = n1 + n2 + n3 + ... + na;
 * 则乘积长度最大为max(n1 * n2 * n3 * ... * na);
 * 由算术几何均值不等式(a + b) / 2 >= (ab)的1/2次方推导得
 * (n1 + n2 + n3 + ... + na) / n >= (n1 * n2 * n3 * ... * na)的1/n次方
 * 设n=ax, 则乘积 f(x) = a的x次方,即f(x) = (n/x)的x次方，则将问题转化为求此函数的极大值
 * 求导，找出极值点，求出最大值
 * <p>
 * 解法二：动态规划f(n) = max(f(i), f(n - i))
 *
 * @author xing
 * @create 2021-03-28 15:24
 */
public class cutRope_14 {
    public static int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 2 * 2;  // 把3和1拆为2*2
        return (int) Math.pow(3, a) * 2;
    }

    // 动态规划
    public static int cuttingRope1(int n) {
        // 基础解
        if (n < 2)
            return 0;
        if (n == 2){
            return 1;
        }
        if (n == 3)
            return 2;

        // dp table
        int[] dp = new int[n + 1];
        // 基础解：base case
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++){
            max = 0;
            for (int j = 1; j < i; j++){
                int product = dp[j] * dp[i - j];
                if (max < product)
                    max = product;
            }
            dp[i] = max;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = cuttingRope1(n);
        System.out.println(ans);
    }
}
