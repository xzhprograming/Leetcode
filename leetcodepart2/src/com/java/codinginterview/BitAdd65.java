package com.java.codinginterview;

/**剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 解题思路：
 * 1. 求不进位和
 * 2.求进位
 * 3.进位为0结束
 * n = a⊕b
 * c = a&b << 1
 *
 * 非进位和：异或运算  不考虑进位：0 + 0和1+1的结果都为0， 0+1和1+0结果为1，满足异或运算
 * 进位：与运算+左移一位，只有都为1才会有进位
 *
 * 若数字 a 和 b 中有负数，则变成了减法
 * 在计算机系统中，数值一律用 补码 来表示和存储。补码的优势： 加法、减法可以统一处理（CPU只有加法器）。因此，以上方法 同时适用于正数和负数的加法 。
 *
 *
 * 扩展：
 * 不增加新变量，交换a、b两个数值
 * a = a + b        a = a ^ b;
 * b = a - b        b = a ^ b;
 * a = a - b        a = a ^ b;
 *
 * @author xing
 * @create 2021-04-07 19:10
 */
public class BitAdd65 {
    public int add(int a, int b) {
        // 异或实现不进位加法
        // 进位由（a & b）<< 1实现
        int sum = 0;  // 不进位和
        int carry = 0; // 进位
        while(b != 0){
            sum = a ^ b; // 求不进位和
            carry = (a & b) << 1; //求进位
            // 循环操作，直到进位为0
            a = sum;
            b = carry;
        }
        return a;
    }
}
