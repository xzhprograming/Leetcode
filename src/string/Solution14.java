package string;

/**
 * @author xingzihao
 * @description
 * 14. 最长公共前缀
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 思路：
 * flower
 * flow
 * flight
 * 直接以第一个字符串为基准，依次遍历每个字符串的相同位置，如果不相等，则截取当前长度，即为最大公共前缀，否则则为第一个字符串
 * @create 2025-04-08 23:08
 **/
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {

        String s0 = strs[0];

        for(int i = 0; i < s0.length(); i++){
            char c = s0.charAt(i);
            for(int j = 0; j < strs.length; j++){
                String s = strs[j];
                if(i == s.length() || c != s.charAt(i)){
                    return s0.substring(0, i);
                }
            }
        }
        return s0;
    }
}
