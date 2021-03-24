package com.java.codinginterview;

import java.util.Scanner;

public class powTest {
    // 超出时间限制
    public static double myPow(double x, int n) {
        //边界条件
        double res = 1.0;
        if (x == 0) return 0;
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            for (int i = 0; i < n; i++) {
                res *= x;
            }
        } else {
            for (int i = 0; i < Math.abs(n); i++) {
                res *= x;
            }
            res = 1.0 /res;
        }
        return res;
    }

    public static double myPow1(double x, int n) {
        // 边界条件
        if(x == 0)
            return 0;
        long p = n;
        double res = 1.0;
        if(p < 0){
            p = -p;
            x = 1.0 / x;
        }
        // 二分法
        while(p > 0){
            // 若p为奇数
//            判断奇数：(p & 1) == 1, 则p为奇数, 二进制位最后一位为1则此数必为奇数
            // 若p为偶数，最后一次得到的模为1，则res = 1.0 * x
            // 若p为奇数，第一次和最后一次得到的模为1，则res = res * x

            if(p % 2 == 1){
                res *= x;
            }
            x = x * x;
            p  = p / 2;  // p >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        double ans = myPow1(x,n);
        System.out.printf("%f", ans);
    }
}
