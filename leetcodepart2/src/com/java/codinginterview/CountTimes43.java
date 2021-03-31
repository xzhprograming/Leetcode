package com.java.codinginterview;

/**
 * @author xing
 * @create 2021-03-31 20:22
 */
public class CountTimes43 {
    public static int countDigitOne(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++){
            System.out.println(i);
            ans += count(i);
        }
        return ans;
    }

    public static int count(int n){
        int ct = 0;
        while(n > 0){
            if(n % 10 == 1){
                ct += 1;
            }
            n = n / 10;
        }
        return ct;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(countDigitOne(n));
    }
}
