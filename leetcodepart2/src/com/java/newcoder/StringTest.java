package com.java.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入输出字符串练习
 *
 * @author xing
 * @create 2021-03-21 14:20
 */
public class StringTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(",");
            Arrays.sort(str);
            for (int i = 0; i < str.length; i++){
                System.out.print(str[i]);
                if (i != str.length - 1)
                    System.out.print(',');
            }
            System.out.println();
        }
    }
}
