package stack;

import java.util.Stack;

/**
 * @author xingzihao
 * @description
 * 1209.删除字符串中的所有相邻重复项 II
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 *
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 *
 * 在执行完所有删除操作后，返回最终得到的字符串。
 *
 * 本题答案保证唯一。
 *
 * 示例 1：
 *
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 *
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * 示例 3：
 *
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 *
 * 思路：
 *  迭代字符串：
 * 如果当前字符与前一个相同，栈顶元素加 1。否则，往栈中压入 1。
 *
 * 如果栈顶元素等于 k，则从字符串中删除这 k 个字符，并将 k 从栈顶移除。
 *
 * @create 2025-05-04 17:17
 **/
public class Solution1209 {

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < sb.length(); i++){
            if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)){
                stack.push(1);
            } else {
                int count = stack.pop() + 1;
                if(k == count){
                    sb.delete(i - k + 1, i + 1);
                    // 需要更新i的位置
                    i = i - k;
                } else {
                    stack.push(count);
                }
            }
        }
        return sb.toString();
    }
}
