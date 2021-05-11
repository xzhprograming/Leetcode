package com.java.hot100;

/**
 *
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * 解题思路：
 * 创建以 3 为根、长度为 7 的不同二叉搜索树，整个序列是[1,2,3,4,5,6,7]
 * G(n) 和序列的内容无关，只和序列的长度有关。于是，F(3,7)=G(2) * G(4)。 因此，我们可以得到以下公式：
 * F(i,n)=G(i−1)* G(n−i)
 *
 * @author xing
 * @create 2021-05-11 22:42
 */
public class UniqueBST96 {
    public int numTrees(int n) {
        // 动态规划

        int[] G = new int[n + 1];

        // base case
        G[0] = 1;
        G[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                G[i] += G[i - j] * G[j - 1];
            }
        }
        return G[n];
    }
}
