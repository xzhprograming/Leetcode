package com.java.codinginterview;

/**剑指 Offer 67. 把字符串转换成整数
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 * 考虑边界条件
 * 1. 非法字符
 * 2.+ -号
 * 3.空白字符
 * 4.数字越界
 * @author xing
 * @create 2021-04-07 20:34
 */
public class StrToInt67 {
    public int strToInt(String str) {

        int max = Integer.MAX_VALUE / 10; // 边界值
        int ans = 0;  // 结果
        int flag = 1; // 判断正负符号

        if(str.length() == 0) return 0;
        char[] sArray = str.toCharArray();

        int left = 0;
        // 跳过所有空字符
        while(sArray[left] == ' '){
            if(left == sArray.length - 1)
                return 0;
            left++;
        }

        // 判断下一位是否为符号位
        if(sArray[left] == '-')
            flag = -1;

        if(sArray[left] == '-' || sArray[left] == '+')
            left++;

        while(left < sArray.length){
            if(sArray[left] < '0' || sArray[left] > '9'){
                break;
            }

            int tmp = sArray[left] - '0';

            // 判断是否越界
            if(ans > max || (ans == max && tmp > 7)){
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + tmp;

            left++;
        }

        return flag * ans;
    }
    public static void main(String[] args) {
        System.out.println(Math.abs(-2147483648 + 1) + 1);
    }
}
