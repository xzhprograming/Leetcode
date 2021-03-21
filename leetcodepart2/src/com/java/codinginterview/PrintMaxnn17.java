package com.java.codinginterview;

import java.util.Scanner;

/**
 * @author xing
 * @create 2021-03-21 14:09
 */
public class PrintMaxnn17 {
    public int[] printNumbers(int n) {
        int maxnum = generateMax(n);
        int[] ans = new int[maxnum];
        for(int i = 0; i < maxnum; i++){
            ans[i] = i + 1;
        }
        return ans;
    }
    public int generateMax(int n){
        int multi = 1;
        int maxnum = 0;
        for(int i = 0; i< n; i++){
            maxnum = 9 * multi + maxnum;
            multi = multi * 10;
        }
        return maxnum;
    }

    public static void main(String[] args) {
        PrintMaxnn17 pm = new PrintMaxnn17();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine(); // 读取一行输入并获取字符串

    }
}
