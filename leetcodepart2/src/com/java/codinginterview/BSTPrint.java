package com.java.codinginterview;

import com.java.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @author xing
 * @create 2021-03-26 16:10
 */
public class BSTPrint {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        // 边界条件
        if(root == null){
            return ans;
        }
        // 用于记录按照什么顺序打印
        // 偶数按照从左到右，偶数按照从右到左
        int flag = 0;
        // 需要对二叉树进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加root节点
        queue.offer(root);
        // 若队列非空
        while(!queue.isEmpty()){
            int size = queue.size();
            // 存储每一层节点
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                // 出队列
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
            }
            // 遍历完当前层后
            if(flag % 2 == 1){ // 从右到左
                List<Integer> list1 = new ArrayList<>();
                for(int i = list.size() - 1; i >= 0; i--){
                    list1.add(list.get(i));
                }
                ans.add(list1);
            }
            else{
                ans.add(list);
            }
            flag++;
        }
        System.out.println(flag);
        return ans;
    }
}
