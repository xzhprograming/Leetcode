package com.java.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * @author xing
 * @create 2021-04-25 21:44
 */
public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        // 数组按照区间左端点值排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> mergedList = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            // 定义左右边界
            int l = intervals[i][0];
            int r = intervals[i][1];

            // 若列表为空，或者当前的左端点大于上一个区间的右端点,则其不连续，即没有重叠区间
            if(mergedList.size() == 0 || mergedList.get(mergedList.size() - 1)[1] < l)
                mergedList.add(new int[]{l, r});
            else{// 有重叠区间
                mergedList.get(mergedList.size() - 1)[1] = Math.max(mergedList.get(mergedList.size() - 1)[1], r);
            }
        }
        int[][] ans = mergedList.toArray(new int[mergedList.size()][]);
//        int[][] ans = mergedList.toArray(new int[][]{});
        return ans;
    }
    public static void main(String[] args) {
    }
}


