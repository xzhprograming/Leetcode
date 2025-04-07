package binarysearchtree;

import java.util.Stack;

/**
 * @author xingzihao
 * @description
 *
 *  152. 验证二叉搜索树的后序遍历序列
 * 请实现一个函数来判断整数数组 postorder 是否为二叉搜索树的后序遍历结果。
 *1. 递归
 *
 *
 * 2. 单调栈
 * 原列表[1,3 ,2,6,5]
 * 设后序遍历倒序列表为arr = [5,6,2,3,1] ，遍历此列表，设索引为 i ，若为 二叉搜索树 ，则有
 * 若 arr[i] > arr[i+1] ，则 arr[i] 为arr[i+1]的右子节点
 * 若 arr[i] < arr[i+1] ，则 arr[i] 一定是某root节点的左子节点，且root节点为arr[i+1，..., n]中的值最接近arr[i]的节点
 * @create 2025-03-01 15:45
 **/
public class Solution152 {

    public boolean verifyTreeOrder(int[] postorder) {
        // 通过递归，判断所有子树的正确性
        // 1. 划分左右子树，遍历后序遍历[start, end]区间，寻找第一个大于根节点的节点，记为m，则可划分为左子树区间[start, m - 1],右子树为[m, end - 1]
        // 2.判断是否为二叉搜索树
        // 左子区间[start, m - 1]所有节点都应 < postorder[end]
        // 右子区间[m, end - 1]所有节点都应 > postorder[end]
        // 遍历右子区间
        // 3. 所有子树都正确才可最终判定正确
        // p=end , p为起始出发点，遍历划分左右子树，如果遍历到p=end，则说明当前树正确
        // recur(start,m−1) ： 判断 此树的左子树 是否正确。
        // recur(m,end−1) ： 判断 此树的右子树 是否正确。
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int start, int end){
        if(start >= end){
            return true;
        }
        int p = start;
        while(postorder[p] < postorder[end]){
            p++;
        }
        int m = p;
        while(postorder[p] > postorder[end]){
            p++;
        }
        boolean current = p == end ? true : false;
        boolean left = recur(postorder, start, m - 1);
        boolean right = recur(postorder, m, end - 1);
        return current && left && right;
    }
    
    public boolean verifyTreeOrder1(int[] postorder) {
        if(postorder.length == 0){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        // 初始化root为最大值
        int root = Integer.MAX_VALUE;

        for(int i = postorder.length - 1; i >= 0; i--){
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i]){
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }




    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int[] postorder = new int[]{5, 6,10,9,4,3};
        boolean b = solution152.verifyTreeOrder(postorder);
        System.out.println(b);
    }
}
