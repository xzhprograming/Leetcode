package dp.stock;

/**
 * @author xingzihao
 * @description
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 *
 * @create 2025-03-17 22:52
 **/
public class Solution122 {

    /**
     * 贪心策略
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        if(prices.length == 2){
            return Math.max(0, prices[1] - prices[0]);
        }
        // 贪心策略: 所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。
        // 后一项减去前一项的差值，如果为正，则即为收益
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i -1];
            if(diff > 0){
                ans += diff;
            }
        }
        return ans;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        // 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润
        // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。

        int[][] dp = new int[prices.length][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < prices.length; i++){
            //如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]，这时候我们要将其卖出，并获得 prices[i] 的收益。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 如果这一天交易完后手里有股票，那么可能的转移状态为前一天有股票，即 dp[i−1][1]，或者前一天结束的时候手里没有股票，即 dp[i−1][0]，这时候我们要买入股票，减少 prices[i] 的收益。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];

    }
}
