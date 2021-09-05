package com.java.codinginterview;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * dp[i] = dp[i - 1] + dp[i - 2], 10 <= 10 * x1 + x2 <= 25
 * <p>
 * dp[i] = dp[i - 1], 10 * x1 + x2 < 10 || 10 * x1 + x2 > 25
 *
 * @author xing
 * @create 2021-04-08 19:41
 */
public class translateNum46 {
//    public static void main(String[] args) {
//        System.out.println('a');
//    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        // 默认每个位置都有一种翻译方式
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        // base case
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            String tmp = s.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public int translateNum1(int num) {
        String s = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i = 2; i < s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = 0;
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                c = a + b;
            } else{
                c = a;
            }
            b = a;
            a = c;
        }
        return a;
    }
}
