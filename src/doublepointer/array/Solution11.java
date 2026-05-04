package doublepointer.array;

/**
 * 11. 盛最多水的容器 (Container With Most Water)
 *
 * 题目描述：
 * 给定 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])
 * 找出两条线，使它们与 x 轴构成的容器可以容纳最多的水
 *
 * 解题思路：双指针 + 贪心
 *
 * 核心策略：移动较短的板
 *
 * 原理分析：
 * 容器面积 = min(h[left], h[right]) × (right - left)
 *
 * 向中间移动时，底边宽度一定减 1，面积变化取决于高度：
 * - 移动短板：min 可能变大 → 面积可能增大
 * - 移动长板：min 不变或变小 → 面积一定减小
 *
 * 因此，每次移动较短的板，才能保证不会错过最优解
 *
 * 算法步骤：
 * 1. 左右指针分别指向数组两端
 * 2. 计算当前面积并更新最大值
 * 3. 移动较短的板，重复直到指针相遇
 *
 * 时间复杂度：O(n) - 双指针遍历一次
 * 空间复杂度：O(1)
 *
 * @author xingzihao
 * @create 2026-05-04 21:48
 **/
public class Solution11 {
    public int maxArea(int[] height) {
        if(height == null || height.length <= 0){
            return 0;
        }
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            // 盛水量计算
            ans = Math.max(Math.min(height[left], height[right]) * (right - left), ans);
            // 哪端小就移动哪端
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
