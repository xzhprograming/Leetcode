package com.java.hot100;

import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 解题思路：
 * 当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。由于后遇到的左括号要先闭合，因此我们可以将这个左括号放入栈顶。
 * 先出现的左括号后匹配
 */
public class VaildBracket20 {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new LinkedList<>();

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                // 提前返回,括号不匹配或栈为空（则当前右括号没有左括号可以匹配）
                if(stack.isEmpty() || !stack.pop().equals(map.get(s.charAt(i)))){
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
