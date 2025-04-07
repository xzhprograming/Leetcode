package doublepointer.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingzihao
 * @description
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * 思路：
 * 1. 初始化双指针 left = right = 0，把索引左闭右开区间 [left, right) 称为一个「窗口」。
 * 2、不断地增加 right 指针扩大窗口 [left, right)，直到窗口中的字符串符合要求（包含了 T 中的所有字符，需要统计字符的频数，各字符频数相等即符合要求）。
 * 3、此时，停止增加 right，转而增加 left 指针缩小窗口 [left, right)，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。
 * @create 2025-02-08 12:49
 **/
public class Solution76 {

    public String minWindow(String s, String t) {
        // 用于统计target和滑动窗口中每个字符出现的次数
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        // 初始化t字符串的频数
        for (char a : charArrayT){
            target.put(a, target.getOrDefault(a, 0) + 1);
        }
        //左右指针
        int left = 0, right = 0;

        int vaild = 0; //用于判断何时对窗口进行收缩

        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        // 滑动窗口先向右移动
        while (right < charArrayS.length){
            // c 为将要移入窗口的字符
            char c = charArrayS[right];

            // 若果t字符串中包含此字符，那么更新origin中字符出现的次数
            if (target.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))){
                    vaild++;
                }
            }
            // 右移窗口
            right++;

            // 当滑动窗口中的元素与t中元素个数相等时，左指针移动，收缩窗口
            while(vaild == target.size()){
                // 更新最小覆盖子串
                // 更新left的位置，同时更新最小子串的长度
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                // d为将要移出窗口的字符
                char d = charArrayS[left];
                //左移窗口
                left++;
                // 进行窗口内字符更新,如果字符不在t字符串内，则left一直向右移动找到
                if (target.containsKey(d)){
                    //有可能最小覆盖子串中包含有重复的字符，可以前进到最前面一个重复字符处进行重置操作，
                    // 先进行判断，再去更新origin中的字符频数
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


    public String minWindow1(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();

        Map<Character, Integer> pattern = new HashMap<>();

        // 初始化
        for(int i = 0; i < t.length(); i++){
            pattern.put(t.charAt(i), pattern.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;
        String ans = "";
        while(right < s.length()){
            char rightCh = s.charAt(right);
            // 增大窗口
            right++;
            window.put(rightCh, window.getOrDefault(rightCh, 0) + 1);

            // 如果已经包含t
            while(containsT(window, pattern)){
                char leftCh = s.charAt(left);
                window.put(leftCh, window.getOrDefault(leftCh, 0) - 1);
                left++;
                int len = right - left + 1;
                if(minLen > len){
                    ans = s.substring(left - 1 > 0 ? left -1 : 0, right);
                    minLen = len;
                }
            }
        }
        return ans;
    }

    public boolean containsT(Map<Character, Integer> window, Map<Character, Integer> pattern){
        for(Map.Entry<Character, Integer> entry : pattern.entrySet()){
            char key = entry.getKey();
            int value = window.getOrDefault(key, 0);
            if(entry.getValue() > value){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        Solution76 solution76 = new Solution76();
        s = solution76.minWindow1(s, t);
        System.out.println(s);
    }
}
