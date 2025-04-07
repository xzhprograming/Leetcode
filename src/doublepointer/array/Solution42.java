package doublepointer.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xingzihao
 * @description
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 思路：
 * 常规解法：
 * 对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]。
 * 朴素的做法是对于数组 height 中的每个元素，分别向左和向右扫描并记录左边和右边的最大高度，然后计算每个下标位置能接的雨水量。
 * 假设数组 height 的长度为 n，该做法需要对每个下标位置使用 O(n) 的时间向两边扫描并得到最大高度，时间复杂度为O(n^2)。
 *
 * 动态规划：
 * 1. 创建一个长度为 n 的数组 leftMax，用于记录下标 i 左边的最大高度，初始化 leftMax[i] = height[i]
 * 2. 创建一个长度为 n 的数组 rightMax，用于记录下标 i 右边的最大高度，初始化 rightMax[i] = height[i]
 * 3. 遍历数组 height，计算下标 i 左边的最大高度，即 leftMax[i] = max(leftMax[i-1], height[i])
 * 4. 倒序遍历数组 height，计算下标 i 右边的最大高度，即 rightMax[i] = max(rightMax[i+1], height[i])
 * 5. 遍历数组 height，计算下标 i 处能接的雨水量，即 res += min(leftMax[i], rightMax[i]) - height[i]
 * 6. 返回 res
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 *
 *
 * @create 2025-03-23 12:14
 **/
public class Solution42 {

    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        // 动态规划
        int n = height.length;
        // 记录左边最大的值
        int[] left = new int[n];

        left[0] = height[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(height[i], left[i - 1]);
        }

        // 记录右边最大的值
        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int res = 0;
        for(int i = 1; i < height.length - 1; i++){
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    // 双指针
    public int trap2(int[] height) {
        int n = height.length;
        // 利用双指针，记录左边和右边的最大值
        int rightMax = height[n - 1];
        int leftMax = height[0];

        //左右两边同时计算雨水容量
        int left = 0;
        int right = n - 1;
        int ans = 0;
        //         当两个指针没有相遇时，进行如下操作：
        // 使用 height[left] 和 height[right] 的值更新 leftMax 和 rightMax 的值；

        // 如果 height[left]<height[right]，则必有 leftMax<rightMax，下标 left 处能接的雨水量等于 leftMax−height[left]，将下标 left 处能接的雨水量加到能接的雨水总量，然后将 left 加 1（即向右移动一位）；

        // 如果 height[left]≥height[right]，则必有 leftMax≥rightMax，下标 right 处能接的雨水量等于 rightMax−height[right]，将下标 right 处能接的雨水量加到能接的雨水总量，然后将 right 减 1（即向左移动一位）。

        // 当两个指针相遇时，即可得到能接的雨水总量。


        //谁小移动谁，相遇的位置一定是最高的柱子
        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if(leftMax < rightMax){
                ans += leftMax - height[left];
                left++;
            } else{
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        // 存储下标,下标单调递增
        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        for(int i = 0; i < height.length; i++){
            //如果栈内至少有两个元素，记栈顶元素为 top，top 的下面一个元素是 left，则一定有 height[left]≥height[top]
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int top = stack.pop();

                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int w = i - left - 1;

                // 左边最大和右边最大值的最小值 - 当前柱子的高度
                int h = Math.min(height[left], height[i]) - height[top];

                ans += w * h;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3};
        int[] num2 = new int[]{1,2};
        num1 = num2;
        System.out.println(Arrays.toString(num1));
    }
}
