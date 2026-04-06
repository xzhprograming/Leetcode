package array.diffarray;

/**
 * @author xingzihao
 * @description
 *
 * 1094.拼车
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips ,  trips[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 * 思路：
 * 核心问题：在于计算每个位置的乘客都是满足最大空座位数量要求的
 * trips[i] 代表着一组区间操作，旅客的上车和下车就相当于数组的区间加减；
 * 只要结果数组中的元素都小于 capacity，就说明可以不超载运输所有旅客
 *
 * @create 2026-04-06 21:41
 **/
public class Solution1094 {

    /**
     * 解法一：暴力解法
     * 对于每个位置，遍历所有行程计算当前乘客数
     */
    public boolean carPoolingBruteForce(int[][] trips, int capacity) {
        // 找到最远的位置
        int maxLocation = 0;
        for (int[] trip : trips) {
            maxLocation = Math.max(maxLocation, trip[2]);
        }

        // 遍历每个位置，检查是否超载
        for (int i = 0; i <= maxLocation; i++) {
            int passengers = 0;
            // 计算当前位置的乘客数
            for (int[] trip : trips) {
                // 乘客在 [from, to) 区间内在车上
                if (trip[1] <= i && i < trip[2]) {
                    passengers += trip[0];
                }
            }
            // 如果超载，返回 false
            if (passengers > capacity) {
                return false;
            }
        }

        return true;
    }

    /**
     * 解法二：差分数组（最优解）
     *
     * 核心思想：
     * 1. 将问题转化为区间修改问题
     * 2. 在 from 位置上车 +passengers，在 to 位置下车 -passengers
     * 3. 使用差分数组高效处理区间修改
     * 4. 最后通过前缀和还原每个位置的乘客数，检查是否超载
     *
     * 时间复杂度：O(n + m)，n 是最大位置数，m 是行程数
     * 空间复杂度：O(n)
     */
    public boolean carPooling(int[][] trips, int capacity) {
        // 找到最远的位置
        int maxLocation = 0;
        for (int[] trip : trips) {
            maxLocation = Math.max(maxLocation, trip[2]);
        }

        // 问题的核心：在于计算每个位置的乘客都是满足最大空座位数量要求的
        int[] diff = new int[maxLocation + 1];

        for(int i = 0; i < trips.length; i++){
            int passengers = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            // 乘客在 [from, to) 区间内在车上
            diff[from] += passengers;
            // 区间 [from, to) 是左闭右开，to 位置已经下车
            // 在 to 位置乘客已经下车，所以在 to 位置减去
            if(to < diff.length){
                diff[to] -= passengers;
            }
        }

        // 还原校验每个车站位置是否满足容量要求
        int currentPassengers = 0;
        for(int i = 0; i < diff.length; i++){
            currentPassengers += diff[i];
            if(currentPassengers > capacity){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1094 solution = new Solution1094();

        // 测试用例1: 期望 false
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        int capacity1 = 4;
        System.out.println("测试用例1: " + solution.carPooling(trips1, capacity1));

        // 测试用例2: 期望 true
        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        int capacity2 = 5;
        System.out.println("测试用例2: " + solution.carPooling(trips2, capacity2));

        // 测试用例3: 期望 true
        int[][] trips3 = {{2, 1, 5}, {3, 5, 7}};
        int capacity3 = 3;
        System.out.println("测试用例3: " + solution.carPooling(trips3, capacity3));

        // 测试用例4: 期望 true
        int[][] trips4 = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        int capacity4 = 11;
        System.out.println("测试用例4: " + solution.carPooling(trips4, capacity4));

        // 测试用例5: 边界情况，位置0就有乘客
        int[][] trips5 = {{5, 0, 3}};
        int capacity5 = 5;
        System.out.println("测试用例5: " + solution.carPooling(trips5, capacity5));
    }
}

