package com.java.codinginterview;

/**求100以内的素数
 *
 * @author xing
 * @create 2021-04-09 13:57
 */
public class PrimeNum {
    // 素数：除了1和本身不能被其他数整除的数
    public static void primeNum(int n){
        for (int i = 2; i <= n; i++){
            boolean flag = true;
            for (int j = 2; j * j < i; j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.print(i);
                System.out.print(' ');
            }
        }
    }

    // 素数筛法
    public static void primeNum1(int n){
        boolean[] flag = new boolean[n]; // 初始化为false
        for (int i = 2; i * i < n; i++){
            // 如果被置为true
            if (flag[i] == false){
                // 从下一个数的平方开始搜索,将i的倍数设置为非素数
                for (int j = i * i; j < n; j += i){
                    flag[j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++){
            if (flag[i] == false){
                System.out.print(i);
                System.out.print(' ');
            }
        }
    }

    public static void main(String[] args) {
//        primeNum(100);
        primeNum1(100);
    }
}
