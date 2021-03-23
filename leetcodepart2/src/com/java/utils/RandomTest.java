package com.java.utils;

import java.util.Random;

public class RandomTest {
    /*伪随机数
    * Random用来创建伪随机数。所谓伪随机数，是指只要给定一个初始的种子，产生的随机数序列是完全一样的。
    要生成一个随机数，可以使用nextInt()、nextLong()、nextFloat()、nextDouble()：
    * 每次运行程序，生成的随机数都是不同的，没看出伪随机数的特性来。
    这是因为我们创建Random实例时，如果不给定种子，就使用系统当前时间戳作为种子，因此每次运行时，种子不同，得到的伪随机数序列就不同。
    如果我们在创建Random实例时指定一个种子，就会得到完全确定的随机数序列：
    * */
    public static void test1(){
        Random r = new Random();
        r.nextInt(); // 2071575453,每次都不一样
        r.nextInt(10); // 5,生成一个[0,10)之间的int
        r.nextLong(); // 8811649292570369305,每次都不一样
        r.nextFloat(); // 0.54335...生成一个[0,1)之间的float
        r.nextDouble(); // 0.3716...生成一个[0,1)之间的double
    }

    public static void main(String[] args) {
        test1();
    }
}
