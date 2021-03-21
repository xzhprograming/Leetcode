package com.java.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数字输入输出练习
 *
 * @author xing
 * @create 2021-03-21 14:26
 */
public class NumberTest {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
//       1. 一直输入模板
//        while (sc1.hasNext()) {
//            int n = sc1.nextInt();
//            int[] array = new int[n];
//            for (int i = 0; i < n; i++) {
//                array[i] = sc1.nextInt();
//            }
//            System.out.println(Arrays.toString(array));
//        }

//        2. 有组数或者输入个数
//        Scanner sc2 = new Scanner(System.in);
//        int n = sc2.nextInt();
//        while (n > 0) {
//            //操作
//            n--;
//        }

//        3. 一行有多个信息 split切分
//        Scanner sc3 = new Scanner(System.in);
//        while(sc3.hasNextLine()){
//            String[] str = sc3.nextLine().split(" ");
//        }

//        4.含结束标志
        /*4. 数组求和   0为结束
         *
         * 输入:
         4 1 2 3 4（4个数 和为1+2+3+4 ）
         5 1 2 3 4 5
         *输出：
         *10
         * 15
         */
        Scanner sc4 = new Scanner(System.in);
        while(sc4.hasNext()){
            int len = sc4.nextInt();
            if (len == 0) {
                return;
            }
            int sum = 0;
            for (int i = 0; i < len; i ++){
                sum += sc4.nextInt();
            }
            System.out.println(sum);
        }
    }
}
