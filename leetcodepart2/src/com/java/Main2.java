package com.java;

import java.util.Scanner;

/**
 * @author xing
 * @create 2021-04-21 9:34
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0){
            int L = sc.nextInt();
            int R = sc.nextInt();
            int k = sc.nextInt();
            int count = 0;
            int tmp = 0;
            for (int i = L; i <= R; i++){
                tmp = Integer.bitCount(i);
                if (tmp == k)
                    count += 1;
            }
            System.out.println(count);
        }
    }
}

