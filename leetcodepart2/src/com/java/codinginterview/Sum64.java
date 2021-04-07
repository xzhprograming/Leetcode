package com.java.codinginterview;

/**
 *剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author xing
 * @create 2021-04-07 17:44
 */
public class Sum64 {
    public static int sumNums1(int n) {
        Sum[] s = new Sum[n];
        for (int i = 0; i < n; i++)
            new Sum();
        return Sum.sum;
    }

    public static int sumNums(int n) {
        boolean flag = n > 0 && (n = n + sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(9));
    }
}

class Sum{
    static int sum = 0;
    static int n = 0;
    public Sum(){
        n++;
        sum += n;
    }
}
