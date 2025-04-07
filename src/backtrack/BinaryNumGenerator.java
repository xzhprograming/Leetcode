package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 *
 * 函数的输入是一个正整数 n，请你返回所有长度为 n 的二进制数（0、1 组成），你可以按任意顺序返回答案。
 * @create 2025-03-04 22:31
 **/
public class BinaryNumGenerator {

    public static List<String> generateBinaryNumbers(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        backtrack(n, sb, list);
        return list;
    }

    private static void backtrack(int n, StringBuilder sb, List<String> list) {

        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i <= 1; i++){
            sb.append(i);
            backtrack(n, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateBinaryNumbers(3));
    }
}
