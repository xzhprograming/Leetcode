package com.java;

import java.util.Arrays;

/**
 * @className: Candy
 * @description:
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * @author: xingzihao
 * @date: 2021/10/22
 **/
public class Candy {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
//        int[] candy = new int[]{1,0,2};
        int[] candy = new int[]{1,2,2};
        solution1.candy(candy);
    }
}

class Solution1 {
    public int candy(int[] ratings) {
        // 需要同时满足左规则和右规则,选取能满足两个规则的最大值
        // 左规则: ratings[i] > ratings[i - 1]时，i的糖果比i - 1多
        // 右规则: ratings[i + 1] > ratings[i]时，i的糖果比i + 1多
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        int num = left[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
            num += Math.max(left[i], right[i]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        System.out.println(num);
        return num;
    }
}

// 增加条件：相同的得分，则分配的糖果个数一样
class Solution2 {
    public int candy(int[] ratings) {
        // 需要同时满足左规则和右规则,选取能满足两个规则的最大值
        // 左规则: ratings[i] > ratings[i - 1]时，i的糖果比i - 1多
        // 右规则: ratings[i + 1] > ratings[i]时，i的糖果比i + 1多
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            } else if (ratings[i] == ratings[i - 1]){
                left[i] = left[i - 1];
            }
        }
        int num = left[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }else if (ratings[i] == ratings[i + 1]){
                right[i] = right[i - 1];
            }
            num += Math.max(left[i], right[i]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        System.out.println(num);
        return num;
    }
}