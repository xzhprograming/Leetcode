package dp;

import java.util.Arrays;

/**
 * @author xingzihao
 * @description
 * 1143.最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 * 思路：二维DP
 * // dp[i][j] 表示 text1[0:i] 和 text2[0:j] 的最长公共子序列的长度
 * // text1[0:i] 表示 text1的长度为 i 的前缀，text2[0:j] 表示 text2的长度为 j 的前缀。
 * 情况1:text1[i - 1] == text2[j - 1]
 * 情况2:text1[i - 1] != text2[j - 1]
 * @create 2025-04-06 21:01
 **/
public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        int n1 = text1.length();
        int n2 = text2.length();
// dp[i][j] 表示 text1[0:i] 和 text2[0:j] 的最长公共子序列的长度
// text1[0:i] 表示 text1的长度为 i 的前缀，text2[0:j] 表示 text2的长度为 j 的前缀。
        int[][] dp = new int[n1 + 1][n2 + 1];

        for(int i = 1; i <= n1; i++){
            char c1 = text1.charAt(i - 1);
            for(int j = 1; j <= n2; j++){
                char c2 = text2.charAt(j - 1);
                // text1[i - 1] = text2[j - 1]
                if(c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // text1[i - 1] != text2[j - 1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }


    /**
     * DFS
     */
    int[][] mem;
    public int longestCommonSubsequence1(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        mem = new int[n1][n2];
        for(int i = 0; i < n1; i++){
            Arrays.fill(mem[i], -1);
        }
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        return dfs(arr1, n1 - 1, arr2, n2 - 1);
    }

    public int dfs(char[] arr1, int i, char[] arr2, int j){
        if(i < 0 || j < 0){
            return 0;
        }

        if(mem[i][j] != -1){
            return mem[i][j];
        }

        if(arr1[i] == arr2[j]){
            mem[i][j] = dfs(arr1, i - 1, arr2, j - 1) + 1;
            return mem[i][j];
        }else {
            mem[i][j] = Math.max(dfs(arr1, i, arr2, j - 1), dfs(arr1, i - 1, arr2, j));
            return mem[i][j];
        }
    }
}
