import java.util.Arrays;

/*31. 下一个排列
* 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。
* 示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]
* */

/*
字典序：
在数学中，字典或词典顺序（也称为词汇顺序，字典顺序，字母顺序或词典顺序）是基于字母顺序排列的单词按字母顺序排列的方法。
对于数字1、2、3......n的排列，不同排列的先后关系是从左到右逐个比较对应的数字的先后来决定的。
例如对于5个数字的排列 12354和12345，排列12345在前，排列12354在后。按照这样的规定，5个数字的所有的排列中最前面的是12345，最后面的是 54321。
全排列{1,2,3} 按照字典序的下一个排列分别是 123、132、213、231、312 和 321
后面一个数总比前面一个数大
解题思路：
下一个排列总是比当前排列要大
找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小


将一个 尽可能小的「大数」 与前面的「小数」交换
首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。

如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i] < a[j]。这样「较大数」即为 a[j]。

交换 a[i] 与 a[j]，此时可以证明区间 [i+1,n) 必为降序。

我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，升序排列就是最小的排列。

链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
* */
public class Solution {
    public void nextPermutation(int[] nums){
        int n = nums.length;
        int small = -1;
        int big = -1;
        if (n <= 2){
            reverse(nums, 0);
            return;
        }
        //查找左边的较小数和右边的较大数
        for(int i = n - 1; i >= 0; i--){
            if (i == 0){
                reverse(nums, 0);//若从n - 1 ~ 0都满足升序，则直接反转此区间数字
                return;
            }
            if(nums[i - 1] < nums[i]) {
                small = i - 1;
                break;
            }
        }
        for (int i = n -1; i > 0; i--){
            if (nums[i] > nums[small]){
                big = i;
                break;
            }
        }
        // 交换较小数和较大数
        swap(nums, small, big);
        reverse(nums, small + 1);
    }
    public void swap(int[] nums, int small, int big){
        int temp = nums[small];
        nums[small] = nums[big];
        nums[big] = temp;
    }
    public void reverse(int[] nums, int start){
        int end = nums.length - 1;
        for (; start < end; start++,end--){
            swap(nums, start, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        //方法一
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        //方法二
        Solution1 solution1 = new Solution1();
        solution1.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution1{
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}