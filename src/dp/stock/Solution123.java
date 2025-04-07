package dp.stock;

/**
 * @author xingzihao
 * @description
 * 123. 买卖股票的最佳时机 III
 * 思路：
 * 由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：
 * 未进行过任何操作；
 * 只进行过一次买操作；
 * 进行了一次买操作和一次卖操作，即完成了一笔交易；
 * 在完成了一笔交易的前提下，进行了第二次买操作；
 * 完成了全部两笔交易。
 *
 * 由于第一个状态的利润显然为 0，因此我们可以不用将其记录。对于剩下的四个状态，我们分别将它们的最大利润记为 buy1，sell1，buy2，sell2。
 * @create 2025-03-17 23:28
 **/
public class Solution123 {

    public int maxProfit(int[] prices) {

        // 初始化第0天利润
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;

        for(int i = 1; i < prices.length; i++){
            // 对于第i天，保持不变，或者在未买入股票的情况下进行一次买操作
            buy1 = Math.max(buy1, -prices[i]);
            // 对于第i天，保持不变，或者在未卖出股票的情况下进行一次卖操作
            sell1 = Math.max(sell1, buy1 + prices[i]);
            // buy2的初始值，应为 sell1 - prices[i]，因为sell1为第一次卖出的利润，而buy2是第i天买入股票的最大利润，
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}
