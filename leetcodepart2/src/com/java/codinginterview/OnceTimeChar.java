package com.java.codinginterview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @author xing
 * @create 2021-03-31 21:40
 */
public class OnceTimeChar {
    public char firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }
        return ' ';
    }

    public char firstUniqChar1(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>(); // 有序哈希表
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(char key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

    }
}
