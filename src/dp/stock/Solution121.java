package dp.stock;

/**
 * @author xingzihao
 * @description
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @create 2025-03-16 20:02
 **/
public class Solution121 {

    public int maxProfit(int[] prices) {
        // 第x天卖出的股票最大利润
        int[] dp = new int[prices.length];

        int min = prices[0];
        int ans = 0;
        for(int i = 0; i < prices.length; i++){
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }
}
