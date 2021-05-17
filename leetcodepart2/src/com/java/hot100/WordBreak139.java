package com.java.hot100;

import java.util.List;

/**
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 链接：https://leetcode-cn.com/problems/word-break
 * @author xing
 * @create 2021-05-17 20:07
 */
public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 解题思路：判断是否可以从wordDict中选取单词组成s
        // 假设s长度为size, 遍历s,则其每个位置上是否可以由wordDict中的单词组成都可得到
        // 即每个位置的状态都与前一位置有关

        int size = s.length();
        // 定义dp数组
        boolean dp[] = new boolean[size + 1];

        // base case
        dp[0] = true;

        for(int i = 1; i <= size; i++){
            for(int j = 0; j <= i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[size];
    }
}
