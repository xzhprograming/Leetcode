package com.java.sildingwindows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 76. 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 特殊情况考虑：
 * t中可能包含重复字符
 *滑动窗口的应用场景有几个特点：
 *
 * 1. 需要输出或比较的结果在原数据结构中是连续排列的；
 *
 * 2. 每次窗口滑动时，只需观察窗口两端元素的变化，无论窗口多长，每次只操作两个头尾元素，当用到的窗口比较长时，可以显著减少操作次数；
 *
 * 3. 窗口内元素的整体性比较强，窗口滑动可以只通过操作头尾两个位置的变化实现，但对比结果时往往要用到窗口中所有元素。
 * 难点：
 * 左右指针交替移动，更改滑动窗口内元素
 * 如何在O（1）的时间内找到下一个left右移后的最小覆盖子串
 *
 * 出错点：
 * 频数超过127了，不能使用==去判断, 要用equals
 * @author xing
 * @create 2021-03-18 16:49
 */
public class minWindow {
    public String minWindow(String s, String t) {
        // 用于统计target和滑动窗口中每个字符出现的次数
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();

//        char[] charArrayS = s.toCharArray();
//        char[] charArrayT = t.toCharArray();
        // 初始化t字符串的频数
        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        //左右指针
        int left = 0, right = 0;

        int vaild = 0; //用于判断何时对窗口进行收缩

        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        // 左右交替移动
        // 滑动窗口先向右移动
        while (right < s.length()){
            // c 为将要移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 若果t字符串中包含此字符，那么更新origin中字符出现的次数
            if (target.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))){
                    vaild++;
                }
            }
            
            // 当滑动窗口中的元素与t中元素个数相等时，左指针移动，收缩窗口
            while(vaild == target.size()){
                // 更新最小覆盖子串
                // 更新left的位置，同时更新最小子串的长度
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                // d为将要移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;
                // 进行窗口内字符更新,如果字符不在t字符串内，则left一直向右移动找到
                if (target.containsKey(d)){
                    //有可能最小覆盖子串中包含有重复的字符，可以前进到最前面一个重复字符处进行重置操作，
                    // 先进行判断，再去更新origin中的字符频数
                    // 频数超过127了，不能使用==去判断, 要用equals
                    if (window.get(d).equals(target.get(d))){
                        vaild--;   
                    }
                    //为什么这里不直接将d移除呢？
                    // 因为t中可能包含重复字符，所以将d所对应出现的次数减1即可
                    //即若不重复则，{d:1}，减一后置为{d：0}， 若重复如{d：2}，减一后置为{d：1}
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
//        String s = "ABCDEFGA";
        String t = "ABC";

        minWindow min = new minWindow();
        String ans = min.minWindow(s, t);
        System.out.println(ans);
        int[] need = new int[128];
        // 利用字符转ASCII码来得到下标
        need['a']++;
        System.out.println(Arrays.toString(need));
    }
}
