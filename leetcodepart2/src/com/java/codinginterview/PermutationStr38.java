package com.java.codinginterview;

import java.util.*;

/**
 *
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 解题思路：
 * 1.将字符串分为两部分：1）第一个字符 2）除第一个字符外的所有字符
 * 2.因此可以将第一个字符与其后面每一个字符进行交换，即将后面每一个字符固定在第一位
 * 3.则第一位后面的字符也可以按照这种方式进行排列，
 * 4.终止条件：直到字符串末尾停止
 * 5.回溯过程需要交换回原始的顺序，因为后面的递进还要使用原始的顺序
 * @author xing
 * @create 2021-03-26 13:56
 */
public class PermutationStr38 {
    List<String> list = new ArrayList<>();
    char[] sArray;
    public String[] permutation(String s) {
        // 穷举所有可能，同时进行剪枝
        sArray = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }
    public void dfs(int start){
        // 终止条件：到达字符串末尾结束
        if(start == sArray.length - 1){
            list.add(String.valueOf(sArray));
            return;
        }
        // 判断字符是否重复
        //将 sArray[i] 加入 Set ，以便之后遇到重复字符时剪枝
        Set<Character> set = new HashSet<>();
        for (int i = start; i < sArray.length; i++){
            // 判断是否为重复元素
            if (set.contains(sArray[i])){
                continue;
            }
            set.add(sArray[i]);
            // 做出选择
            // 固定字符： 将字符 sArray[i] 和 sArray[start] 交换，即固定 sArray[i] 为当前位字符；
            swap(sArray, i, start);
            // 遍历下一个位置
            // 开启下层递归： 调用 dfs(x + 1) ，即开始固定第 start + 1 个字符；
            dfs(start + 1);
            // 撤销选择
            swap(sArray, i, start);
        }
    }
    public void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        PermutationStr38 ps = new PermutationStr38();
        String[] ans = ps.permutation("abc");
        for (String s : ans)
            System.out.println(s);
    }
}
