package com.java.codinginterview;

/**
 * @author xing
 * @create 2021-03-20 17:58
 */
public class Jumpfrog {
    public int numWays(int n) {
        //滚动数组fib
        //first second result
        // 0      0      1

        // n = 1时，f(1) = 1
        // n = 2时， f(2) = 2;
        // n = 3时
        // 1.当第一次跳1级台阶，下次跳法为f(n - 1)
        // 2.当第一次跳2级台阶，下次跳法为f(n - 2)
        // 边界条件
        if (n == 0)
            return 1;
        int first = 1, second = 2;
        int result = 0;
        for (int i = 3; i <= n; i++){
            // 防止数值过大溢出
            result = (second + first) % 1000000007;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Jumpfrog j = new Jumpfrog();
        System.out.println(j.numWays(5));
    }
}
