package com.java.codinginterview;

import java.util.Scanner;

public class powTest {
    // 超出时间限制
    public static double myPow(double x, int n) {
        //边界条件
        double res = 1.0;
        if (x == 0 && n < 0) return 0;
        if (x == 0 && n >= 0) return 1;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        double ans = myPow(x,n);
        System.out.printf("%f", ans);
    }
}
