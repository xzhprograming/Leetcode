package com.java.codinginterview;

import java.util.ArrayList;
import java.util.Arrays;

/**剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *解题思路：
 * 1.递归
 * 将n个骰子分为两堆，第一堆只有一个，第二堆有n-1个
 * 单独的那一个有可能出现1-6的点数
 * 需要计算1-6的每一种点数与第二堆的点数和，
 * 将n-1个再拆分为1个和n-2个
 * 递归结束条件即为只剩最后一个骰子

 * @author xing
 * @create 2021-04-03 16:05
 */
public class Probability60 {
    int max = 6;
    public double[] dicesProbability(int n) {
        if (n < 1){
            return new double[0];
        }
        int maxSum = n * max;  // 和的最大值为6n, 最小值为n，即全为6和全为1
        int[] probabilty = new int[maxSum - n + 1];

        return new double[0];

    }

    public void probablity(int n, int [] probability){
        for (int i = 1; i < n * max; i++){
            probability(n, n, i, probability);
        }
    }
    public void probability(int original, int current, int sum, int[] probability){

    }

    public static void main(String[] args) {
        Integer a = new Integer(2);
        Double d = new Double(2);
    }
}
