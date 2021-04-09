package com.java.codinginterview;

/**剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 *
 * @author xing
 * @create 2021-04-09 16:00
 */
public class UglyNumber49 {
    public int nthUglyNumber(int n) {
        if (n < 0)
            return 0;
        int[] dp = new int[n]; // 存储前n个丑数

        //base case
        dp[0] = 1;

        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        // 设当前丑数为a
        // 如果a为丑数，则a*2, a*3, a*5也必为丑数
        // 所以只剩下丑数顺序的问题？？？？

        // 定义三个指针，分别指向m2, m3, m5
        // 下一个丑数则为这三个数中的最小值
        for (int i = 1; i < n; i++) {
            int p2 = dp[m2] * 2;
            int p3 = dp[m3] * 3;
            int p5 = dp[m5] * 5;
            int min = Math.min(Math.min(p2, p3), p5);
            dp[i] = min;
            // 每轮计算 dp[i]dp[i] 后，需要更新索引 m2, m3, m5的值
            if (p2 == min)
                m2++;
            if (p3 == min)
                m3++;
            if (p5 == min)
                m5++;
        }
        return dp[n - 1];
    }
}
