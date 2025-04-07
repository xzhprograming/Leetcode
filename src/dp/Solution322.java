package dp;

import java.util.Arrays;

/**
 * @author xingzihao
 * @description
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * @create 2025-03-13 22:26
 **/
public class Solution322 {


    // 递归解法
    public int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount);
    }

    // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
    int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 优化： 递归 + 备忘录
     */
    class Solution1 {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
            Arrays.fill(memo, -666);

            return dp(coins, amount);
        }

        int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            // 查备忘录，防止重复计算
            if (memo[amount] != -666)
                return memo[amount];

            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1) continue;
                // 在子问题中选择最优解，然后加一
                res = Math.min(res, subProblem + 1);
            }
            // 把计算结果存入备忘录
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }

    /**
     * 动态规划：
     */
    class Solution2 {
        public int coinChange(int[] coins, int amount) {

            // 当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出
            int[] dp = new int[amount + 1];
            // 数组大小为 amount + 1，初始值也为 amount + 1
            Arrays.fill(dp, amount + 1);

            // base case
            dp[0] = 0;
            // 外层 for 循环在遍历所有状态的所有取值
            for (int i = 0; i < dp.length; i++) {
                // 内层 for 循环在求所有选择的最小值
                for (int coin : coins) {
                    // 子问题无解，跳过
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount] == amount + 1) ? -1 : dp[amount];
        }
    }
}
