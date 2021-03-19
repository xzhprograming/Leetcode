package com.java.sildingwindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xing
 * @create 2021-03-19 16:40
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // 使用滑动窗口在字符串p上进行滑动

        int pLen = p.length();
        //  用于存储索引
        List<Integer> ans = new ArrayList<>();
        // 定义滑动窗口和字符串s
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();

        // 初始化s中字符串的频数
        for(int i = 0; i < p.length(); i++){
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
        }

        //定义左右指针
        int left = 0;
        int right = 0;

        // 判断窗口何时进行收缩
        int vaild = 0;
        // 右指针移动
        while(right < s.length()){
            char r = s.charAt(right);

            // 如果此字符在target内，则将其添加到window
            if(target.containsKey(r)){
                window.put(r, window.getOrDefault(r, 0) + 1);
                if(target.get(r).equals(window.get(r)))
                    vaild++;
            }

            // 如果当前子串的长度小于s的长度，那么right需要右移
            right++;

            while(vaild == target.size()){
                if(right - left == pLen){
                    ans.add(left);
                }
                char l = s.charAt(left);

                if(target.containsKey(l)){
                    if(target.get(l).equals(window.get(l)))
                        vaild--;
                    window.put(l, window.getOrDefault(l, 0) - 1);
                }
                //左指针右移，更新滑动窗口
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";

        FindAnagrams fa = new FindAnagrams();
        System.out.println(fa.findAnagrams(s, p));
    }
}
