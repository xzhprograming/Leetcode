package com.java.codinginterview;

/**
 *
 * 剑指 Offer 05. 替换空格:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @author xing
 * @create 2021-03-19 21:13
 */
public class ReplaceBlank_05 {
    public String replaceSpace(String s) {
        int n = s.length();
        // 申请3倍与原字符串的内存
        int size = 0;
        char[] newString = new char[3 * n];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                newString[size++] = '%';
                newString[size++] = '2';
                newString[size++] = '0';
            }
            else{
                newString[size++] = c;
            }
        }
        return new String(newString, 0, size);
//        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        String a = "We are happy.";
        ReplaceBlank_05 rb = new ReplaceBlank_05();
        String ans = rb.replaceSpace(a);
        System.out.println(ans);
    }
}
