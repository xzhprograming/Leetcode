package doublepointer.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xingzihao
 * @description
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 思路;
 * 异位词，即为给定的p的排列，即找到符合p排列的所有子串
 * 通过记录字符频数和子串长度确定是否为符合要求的异位词
 *
 * 1. right向前扩大窗口，记录符合要求的字符频数
 * 2. left向前收缩窗口，判断是否位符合条件的异位词，记录其位置下标
 *
 * @create 2025-02-09 13:07
 **/
public class Solution438 {

    public List<Integer> findAnagrams(String s, String p){

        //初始化窗口
        Map<Character, Integer> window = new HashMap<>();

        // 初始化匹配字符串p的各字符频数
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0 ; i < p.length(); i++){
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }


        // 初始化左右双指针
        int left = 0;
        int right= 0;
        // 记录位置下标结果
        List<Integer> list = new ArrayList<>();

        // 字符串有效校验
        int valid = 0;

        while(right < s.length()){
            char rightCh = s.charAt(right);
            if(need.containsKey(rightCh)){
                window.put(rightCh, window.getOrDefault(rightCh, 0) + 1);
                if(window.get(rightCh).equals(need.get(rightCh))){
                    valid++;
                }
            }
            // 扩大窗口
            right++;

            //p中字符可能重复，所以需要使用need.size()进行判断
            while(valid == need.size()){
                if(right - left == p.length()){
                    list.add(left);
                }
                char leftCh = s.charAt(left);
                if(need.containsKey(leftCh)){
                    if(need.get(leftCh).equals(window.get(leftCh))){
                        valid--;
                    }
                    window.put(leftCh, window.getOrDefault(leftCh, 0) - 1);
                }
                // 缩小窗口
                left++;
            }

        }

        return list;
    }

    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        Solution438 solution438 = new Solution438();
        List<Integer> list = solution438.findAnagrams(s, p);
        System.out.println(list);
    }
}
