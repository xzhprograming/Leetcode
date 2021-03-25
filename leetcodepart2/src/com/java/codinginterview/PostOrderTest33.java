package com.java.codinginterview;

/**
 *剑指 Offer 33. 二叉搜索树的后序遍历序列
 *输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 解题思路：
 * 后序遍历定义： [ 左子树 | 右子树 | 根节点 ] ，即遍历顺序为 “左、右、根” 。
 * 二叉搜索树定义： 左子树中所有节点的值 << 根节点的值；右子树中所有节点的值 >> 根节点的值；其左、右子树也分别为二叉搜索树。
 *递归分治
 * 根据二叉搜索树的定义，可以通过递归，判断所有子树的 正确性 （即其后序遍历是否满足二叉搜索树的定义） ，若所有子树都正确，则此序列为二叉搜索树的后序遍历。
 * 递归解析：
 * 终止条件： 当 i≥j ，说明此子树节点数量≤1 ，无需判别正确性，因此直接返回 true ；
 * 递推工作：
 * 划分左右子树： 遍历后序遍历的 [i, j] 区间元素，寻找 第一个大于根节点 的节点，索引记为 m 。此时，可划分出左子树区间 [i,m-1] 、右子树区间[m,j−1] 、根节点索引 j 。
 * 注意：************************
 * 判断是否为二叉搜索树：
 * 左子树区间 [i, m - 1] 内的所有节点都应 < postorder[j] 。而第 1.划分左右子树 步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可。
 * 右子树区间 [m, j-1] 内的所有节点都应 > postorder[j] 。实现方式为遍历，当遇到 ≤postorder[j] 的节点则跳出；则可通过p=j 判断是否为二叉搜索树。
 * ***********************************
 * 返回值： 所有子树都需正确才可判定正确，因此使用 与逻辑符 \&\&&& 连接。
 * p = j ： 判断 此树 是否正确。
 * recur(i, m - 1)： 判断 此树的左子树 是否正确。
 * recur(m, j - 1) ： 判断 此树的右子树 是否正确。
 *

 * @author xing
 * @create 2021-03-25 16:00
 */
public class PostOrderTest33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end){
        // 递归终止条件
        if(start >= end){
            return true;
        }
        // 查找左右子树部分
        int index = start;
        for(; index < end; index++){
            if(postorder[index] > postorder[end]){
                break;
            }
        }
        int right = index;
        for(; right < end; right++){
            if(postorder[right] < postorder[end]){
                break;
            }
        }
        // 所有子树都需正确才可判定正确
        boolean flag = (right == end);
        boolean leftpart = verifyPostorder(postorder, start, index - 1);
        boolean rightpart = verifyPostorder(postorder, index, end - 1);  // end为根节点元素， end - 1,依次判断末尾元素
        // 左右子树都满足二叉搜索性质
        return flag && leftpart && rightpart;
    }
}
