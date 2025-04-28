package doublepointer.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 *658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 思路：二分查找
 * 假设一共有 5 个数，不管 x 的值是多少，在 [0, 1, 2, 3, 4]，找 3 个数，左边界最多到 2；
 * 假设一共有 8 个数，不管 x 的值是多少，在 [0, 1, 2, 3, 4, 5, 6, 7]，找 5 个数，左边界最多到 3。
 * 因此，「最优区间的左边界」的下标的搜索区间为 [0, size - k]。注意：这个区间的左右都是闭区间，都能取到
 *从 [0, size - k] 这个区间的任意一个位置（用「二分查找」就是当前候选区间的中位数）开始，定位一个长度为 (k + 1) 的区间，根据这个区间是否包含 x 开展讨论。
 *
 * 如果区间包含 x，我们尝试删除 1 个元素，好让区间发生移动，便于定位「最优区间的左边界」的下标；
 * 如果区间不包含 x，就更简单了，我们尝试把区间进行移动，以试图包含 x，极端情况下也有可能区间移动不了。
 *
 * @create 2025-04-27 22:35
 **/
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;

        while(left < right){
            int mid = left + (right - left) / 2;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if(x - arr[mid] > arr[mid + k] - x){
                // 下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left..mid]
                right = mid;
            }
        }

        for(int i = left; i < left + k; i++){
            ans.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution658 solution658 = new Solution658();
        int[] arr = new int[]{0,1,1,1,2,3,6,7,8,9};
        int k = 9;
        int x = 4;
        List<Integer> closestElements = solution658.findClosestElements(arr, k, x);
        System.out.println(closestElements);
    }
}
