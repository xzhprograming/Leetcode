package doublepointer.slidewindow;

import java.util.*;

/**
 * @author xingzihao
 * @description
 * 3. 无重复字符的最长子串
 *给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 思路：
 * 枚举下一个字符作为起始位置，然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。
 * 在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串
 *
 * @create 2025-02-09 13:40
 **/
public class Solution3 {

    public int lengthOfLongestSubstring(String s){

        // 初始化左右双指针
        int left = 0;
        int right = 0;

        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s){

        // 初始化左右双指针
        int left = 0;
        int right = 0;
        int maxLength = 0;

        Map<Character, Integer> window = new HashMap<>();

        while(right < s.length()){
            char rightCh = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            window.put(rightCh, window.getOrDefault(rightCh, 0) + 1);

            while(window.get(rightCh) > 1){
                char leftCh = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                window.put(leftCh, window.get(leftCh) - 1);
            }
            // 更新最终答案
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring(s));
        String s1 = "asdas,dasd,asd,asd,a";
        System.out.println(Arrays.toString(s1.split(",")));
    }
}
