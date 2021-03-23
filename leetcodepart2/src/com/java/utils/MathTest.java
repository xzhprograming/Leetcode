package com.java.utils;

public class MathTest {
    public static void test1(){
        // 求绝对值
        Math.abs(-100);

        //求最大值最小值
        Math.max(10 ,8);
        Math.min(2.3, 4.1);

        // 计算x的y次方
        Math.pow(2, 10);

        // 计算根号x
        Math.sqrt(2);

        //计算e的x次方
        Math.exp(2);

//        计算以e为底的对数
        Math.log10(100);
//        三角函数
        Math.sin(3.14); // 0.00159...
        Math.cos(3.14); // -0.9999...
        Math.tan(3.14); // -0.0015...
        Math.asin(1.0); // 1.57079...
        Math.acos(1.0); // 0.0
        //数学常量
        double pi = Math.PI; // 3.14159...
        double e = Math.E; // 2.7182818...
        Math.sin(Math.PI / 6); // sin(π/6) = 0.5
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

    }
}
