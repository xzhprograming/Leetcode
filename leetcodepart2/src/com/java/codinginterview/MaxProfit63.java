package com.java.codinginterview;

/**
 * @author xing
 * @create 2021-04-07 17:13
 */
public class MaxProfit63 {
    public static int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null)
            return 0;
        int max = 0; // 设置最大利润

        int minPrice = prices[0];// 记录最小价格

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice)
                minPrice = prices[i]; // 更新最小价格
            max = Math.max(max, prices[i] - minPrice);// 更新最大利润
        }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
