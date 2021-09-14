import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //方法一
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //1.先算出一共有几种
        int len = 1;
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - '0';
            len *= strs[c].length();
        }

//再用求余方法拿到每一种
        /*
         * 以"23"为例，可能种类有3*3=9种，对应00，01，02，10，11，12，20，21，22
         * 0~9 / 3 的范围为 0~2
         * 0~9 % 3 的范围为 0~2，
         * 因此可以遍历得到所有的可能
         * 类似于十进制到二进制的转换：
         * 10 / 2 余 0，商5
         * 5 / 2 余 1，商2
         * 2 / 2 余 0，商1
         * 1 / 2 余 1，商0
         * 得到结果1010
         * 每一个可能都对应此种类似进制转换下的一个值，求模后继续用商进行求模*/
//        for(int i = 0 ; i < len; i++){
//            int last = i;
//            StringBuilder sb = new StringBuilder();
//            for(int j = 0; j<=digits.length()-1;j++){
//                int c = digits.charAt(j)-'0';
//                int pos = last%strs[c].length();// 取其余数
//                sb.append(strs[c].charAt(pos));
//                last = last/strs[c].length();//？？？？类似于十进制到二进制的转换，00，01
//            }
//            result.add(sb.toString());
//        }
        for (int i = 0; i < len; i++) {
            int last = i;
            StringBuilder sb = new StringBuilder();
            for (int j = digits.length() - 1; j >= 0; j--) {
                int c = digits.charAt(j) - '0';
                int pos = last % strs[c].length();// 取其余数
                sb.append(strs[c].charAt(pos));
                last = last / strs[c].length();//？？？？类似于十进制到二进制的转换，00，01
            }
            result.add(sb.reverse().toString());
        }
        return result;
    }

    //方法二
    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        Solution solution = new Solution();
        List<String> ans = solution.letterCombinations(digits);
        List<String> ans1 = solution.letterCombinations1(digits);
        System.out.println(ans.toString());
        System.out.println(ans1.toString());
    }

    @Test
    public void test1() {
        System.out.println('A' - '0');
    }
}

