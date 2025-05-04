package stack;

import java.util.Stack;

/**
 * @author xingzihao
 * @description
 * 1249. 移除无效的括号
 *给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串
 *示例 1：
 *
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 *
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 *
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 *
 * 思路：
 * 1. 利用栈进行括号匹配
 * 2. 标记要删除的括号位置
 * 3. 输出删除后的字符串
 *
 * @create 2025-05-02 15:50
 **/
public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        // 记录'('位置,利用栈进行括号匹配
        Stack<Integer> stack = new Stack<>();

        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            // 标记要删除的括号位置
            if(arr[i] == '('){
                stack.push(i);
            } else if(arr[i] == ')'){
                if(stack.isEmpty()){
                    arr[i] = '\0';
                } else{
                    stack.pop();
                }
            }
        }
        // 遍历完后，栈中的都为无效括号
        while(!stack.isEmpty()){
            int index = stack.pop();
            arr[index] = '\0';
        }
        // 输出删除无效括号后的字符串
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != '\0'){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
