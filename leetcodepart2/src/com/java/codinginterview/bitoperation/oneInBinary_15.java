package com.java.codinginterview.bitoperation;

import java.util.Scanner;

/**
 * @author xing
 * @create 2021-03-22 19:34
 */
public class oneInBinary_15 {
    // you need to treat n as an unsigned value
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        // 依次判断最后一位是否为1
        int count = 0;
        // 循环终止条件
        while(n != 0){
            if((n & 1) != 0) //& 的优先级小于 !=
                count++;
            n = n >>> 1;// 无符号右移
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        System.out.println(hammingWeight(input1));
    }
}
