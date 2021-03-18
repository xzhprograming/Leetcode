package com.java.sildingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 567. 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 解题思路：
 * 1. 统计字符串s1中每个字符出现的频数
 * 2.利用滑动窗口从左至右找到其子串
 * 3. 判断其长度是否与s1相同
 *
 * @author xing
 * @create 2021-03-18 22:47
 */
public class PermString {
    public boolean checkInclusion(String s1, String s2) {
        // 定义两个字典，分别对s1和s2中的字符进行频数统计
        // 在s2上进行滑动窗口操作，在s2上面滑
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();

        int s1Len = s1.length();

        // 初始化target频数
        for(int i = 0; i < s1.length(); i++){
            char a = s1.charAt(i);
            target.put(a, target.getOrDefault(a, 0) + 1);
        }

        //定义左右指针
        int left=0,right=0;
        int len = Integer.MAX_VALUE;
        int vaild = 0; //定义合适对窗口进行缩小
        while(right < s2.length()){
            char r = s2.charAt(right);
            // 若right指向的字符存在于target中
            if(target.containsKey(r)){
                window.put(r, window.getOrDefault(r, 0) + 1);
                if(window.get(r).equals(target.get(r))){
                    vaild++;
                }
            }
            // 右窗口右移
            right++;

            // 当滑动窗口中的值包含target中的值时
            while(vaild == target.size()){
                // 若滑动窗口中的长度与s2长度相同
                if(right - left < len){
                    len = right - left;
                    System.out.println(len);
                    if(len == s1Len)
                        return true;
                }
                //不相同则继续查找下一个可能的子串
                char l = s2.charAt(left);
                left++;

                if(target.containsKey(l)){

                    if(window.get(l).equals(target.get(l)))
                        vaild--;
                    window.put(l, window.getOrDefault(l, 0) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermString p = new PermString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        p.checkInclusion(s1, s2);
    }
}
