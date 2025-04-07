package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xingzihao
 * @description
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @create 2025-03-10 23:39
 **/
public class Solution17 {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        int len = digits.length();

        if(len == 0){
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char[] di = digits.toCharArray();
        backtrack(di, 0, new StringBuilder(), map);
        return ans;
    }

    public void backtrack(char[] di, int index, StringBuilder sb, Map<Character, String> map){
        if(sb.length() == di.length){
            ans.add(sb.toString());
            return;
        }
        String s = map.get(di[index]);
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            backtrack(di, index + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
