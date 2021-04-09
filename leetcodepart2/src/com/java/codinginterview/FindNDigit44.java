package com.java.codinginterview;

/**
 * @author xing
 * @create 2021-04-09 20:04
 */
public class FindNDigit44 {
    public static int findNthDigit(int n) {
        // 找规律
        // 0 - 9        10个数字 10位
        // 10 - 99      90个数字 180位
        // 100 - 999    900个数字 2700位

        int digit = 1; // 数的位数
        long nums  = 9; // 数的个数
        long bit = 10; // 各个段的总位数
        // 找到当前数位于哪个段
        while(n >= bit){
            n -= bit;
            digit++;
            nums = numCompute(digit);
            bit = digit * nums;
        }

        long num = n / digit;
        int mod = n % digit;
        long ans = num;
        if (digit != 1)
            ans = (long) Math.pow(10, digit - 1) + num;
        String s = Long.toString(ans);
//        return s.charAt(mod) - '0';

        long res = modCompute(ans, digit - mod);
        return (int) res;
    }

    // 求数的位数
    public static long numCompute(int digit){
        if(digit == 1)
            return 10;
        int count = (int) Math.pow(10, digit - 1);
        return count * 9;
    }

    public static long modCompute(long ans, int mod){
        long tmp = 0;
        for (int i = 1; i < mod; i++)
            ans /= 10;
        tmp = ans % 10;
        return tmp;
    }


    public static int findNthDigit1(int n) {
        // 找规律
        // 分为以下几段
        // 0
        // 1 - 9        9个数字 9位
        // 10 - 99      90个数字 180位
        // 100 - 999    900个数字 2700位
        long digit = 1; // 数的位数
        long start = 1; // 开始的数值
        long count = 9; // 开始的总位数

        while(n > count){
            n -= count;
            start *= 10;
            digit++;
            count = digit * start * 9;
        }
        // 判断位于哪个数中
        long num = (n - 1) / digit + start;
        int index = (int) ((n - 1) % digit);
        return Long.toString(num).charAt(index) - '0';
    }
    public static void main(String[] args) {
        System.out.println(findNthDigit1(9));
//        System.out.println(modCompute(123, 3 - 3 + 1));
    }
}
