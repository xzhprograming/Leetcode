package dp;

import java.util.Arrays;

/**
 * @author xingzihao
 * @description
 * 354. 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 *
 * 思路：
 * 先按宽度w升序排列，若w相同则其再按照高度h降序排列，不相同则升序。
 * 那么w的顺序已经固定，可以从前向后嵌套，只需要考虑高度h的嵌套即可。
 *
 * 问题到这里已经变为考虑h维度上，最长递增子序列的问题了
 *
 * @create 2025-03-13 23:21
 **/
public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        //对高度找最长递增子序列
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++){
            height[i] = envelopes[i][1];
        }

        int res = Solution300.lengthOfLIS(height);
        return res;
    }

}
