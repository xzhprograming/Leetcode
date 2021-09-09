package com.java.codinginterview;

/**剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *     // 解题思路：
 *     // 先全部倒置，再局部倒置
 * @author xing
 * @create 2021-04-02 23:24
 */
public class RotatedLeftString58 {
    // 解题思路：
    // 先全部倒置，再局部倒置
    public String reverseLeftWords(String s, int n) {
        // 边界条件
        if(s == "")
            return "";
        char[] arr = s.toCharArray();
        int end = arr.length - 1;
        reverse(arr, 0, end);
        reverse(arr, 0, end - n);
        reverse(arr, end - n + 1, end);
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
}
