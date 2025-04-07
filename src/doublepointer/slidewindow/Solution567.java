package doublepointer.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingzihao
 * @description
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输入：s1 = "ab" s2 = "aidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * 思路：
 * 1. 什么是最终符合条件的？若子串的字符频数、长度相同，则该子串即为s1的排列
 * 2. 何时扩大窗口，扩大窗口需要更新哪些数据
 * 3. 何时缩小窗口，缩小窗口需要更新哪些数据
 * 4. 我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
 * 在收缩时找到最终结果
 * right指针右移，扩大窗口寻找符合条件的子串， 即找到可行解
 * left指针右移，收缩寻找最终结果，即优化可行解，找到符合条件的最优解
 * @create 2025-02-08 15:27
 **/
public class Solution567 {

    public boolean isSubString(String s1, String s2) {

        // 初始化窗口和匹配的字符频数
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while(right < s2.length()){
            char rightCh = s2.charAt(right);
            if(need.containsKey(rightCh)){
                window.put(rightCh, window.getOrDefault(rightCh, 0) + 1);
                if(window.get(rightCh).equals(need.get(rightCh))){
                    valid++;
                }
            }
            // 扩大窗口
            right++;

            while(valid == need.size()){
                if(right - left == s1.length()){
                    return true;
                }
                char leftCh = s2.charAt(left);
                if(need.containsKey(leftCh)){
                    if(need.get(leftCh).equals(window.get(leftCh))){
                        valid--;
                    }
                    window.put(leftCh, window.getOrDefault(leftCh, 0) - 1);
                }
                // 收缩窗口
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        Solution567 solution567 = new Solution567();
        boolean b = solution567.isSubString(s1, s2);
        System.out.println(b);
    }
}
