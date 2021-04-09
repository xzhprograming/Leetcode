package com.java.codinginterview;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * @author xing
 * @create 2021-04-08 19:41
 */
public class translateNum46 {
//    public static void main(String[] args) {
//        System.out.println('a');
//    }

    public int tran(int num) {
        String input = num + "";
        int[] dp = new int[input.length()];
        dp[0] = 1;
        for (int i = 1; i < input.length(); ++i) {
            if (Integer.parseInt(input.substring(i - 1, i + 1)) <= 25) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[input.length() - 1];
    }
}
