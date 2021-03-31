package com.java.codinginterview;

import java.util.Scanner;

/**
 * @author xing
 * @create 2021-03-30 16:08
 */
public class findNthDigit44 {
    public static int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++){
            sb.append(Integer.toString(i));
        }
        char ans = sb.charAt(n);
        return ans - '0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findNthDigit(n));
    }
}
