package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @create 2025-03-23 16:57
 **/
public class Solution56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i< intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            int size = list.size();
            // 列表为空，或者列表中末尾元素的右数 < 当前的left，则不满足合并条件
            if(size == 0 || list.get(size - 1)[1] < left){
                list.add(new int[]{left, right});
            } else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {{1,4},{5,6}};

        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(intervals);
        for(int[] i : merge){
            System.out.println(Arrays.toString(i));
        }
    }
}
