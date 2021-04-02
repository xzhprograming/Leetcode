package com.java.codinginterview;

/**
 * @author xing
 * @create 2021-04-02 22:35
 */
public class ReverseWord {
    // 将整个字符串反转，再以' '为分隔符反转每个单词
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, s.length() - 1);
        int start = 0;
        int end = 0;
        while(start < arr.length){
            if(arr[start] == ' '){
                start++;
                end++;
            }
            else if(end == arr.length || arr[end] == ' '){
                reverse(arr, start, end - 1);
                start = end;
            }
            else{
                end++;
            }
        }
        return new String(arr);
    }
    public void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 先去除首尾空格，再从末尾依次将其取出添加到新的字符串中
    public static String reverseWords1(String s) {
        s = s.trim(); // 去除首尾空格
        StringBuilder sb = new StringBuilder();
        int left = s.length() - 1;
        int right = left;
        while(left >= 0){
            // 找到第一个为' '的字符
            while(left >= 0 && s.charAt(left) != ' ')
                left--;
            sb.append(s.substring(left + 1, right + 1));
            sb.append(' ');
            // 跳过空字符
            while(left >= 0 && s.charAt(left) == ' ')
                left--;
            right = left;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords1( "the sky is blue"));
    }
}
