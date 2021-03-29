package com.java.dp;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * @author xing
 * @create 2021-03-28 16:38
 */
public class CoinChange {
    static int res = Integer.MAX_VALUE;
    static int[] mem;
    // 常规递归，遍历所有可能结果，遍历整个多叉树
    public static int coinChange(int[] coins, int amount) {
        // 边界条件
        if (amount == 0)
            return 0;
        count(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static void count(int[] coins, int amount, int count){
        // 终止条件
        if (amount == 0)
            res =  Math.min(res, count);
        if (amount < 0)
            return;
        // 遍历每个coin，同时更新amount，count
        // amount为剩余的金额，count为硬币个数
        for (int coin : coins){
            count(coins, amount - coin, count + 1);
        }
    }
    //   设置备忘录版本
    // 使用数组，或者HashMap作为备忘录
    public static int coinChange1(int[] coins, int amount) {
        mem = new int[amount + 1]; // 声明为amout+1，则下标对应0,1,2,...,amount
        return count1(coins, amount);
    }
    public static int count1(int[] coins, int amount){

        // 终止条件
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        // 防止amount小于0越界，因此终止条件放在后面
        if (mem[amount] != 0)
            return mem[amount];

        int res = Integer.MAX_VALUE;

        for (int coin : coins){
            int subproblem = count1(coins, amount - coin);
            if(subproblem == -1) // 子问题无解
                continue;
            else{ // 子问题有解，硬币数加1，与res相比取其最小值
                res = Math.min(res, subproblem + 1);
            }
        }
        // 计入备忘录
        mem[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return mem[amount];
    }

    // 使用DP Table
    public static int coinChange2(int[] coins, int amount){
        // 初始化dp table
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++){
            dp[i] = amount + 1;
        }
        // base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++){
            for (int coin : coins){
                // 若不能凑齐，则继续遍历
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1); // 加1即当前值到下一个接近的值的距离
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            int[] input = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                input[i] = Integer.parseInt(str[i]);
            }
            int amount = sc.nextInt();
            int ans = coinChange2(input, amount);
            System.out.println(ans);
        }
    }
}
