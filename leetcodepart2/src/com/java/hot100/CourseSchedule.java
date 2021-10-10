package com.java.hot100;

import java.util.*;
/**
 * @className: CourseSchedule
 * @description:
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 *
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 *
 * 解题思路：
 * 问题抽象：判断课程安排关系是否为有向无环图，拓扑排序
 * BFS: 构造入度表和邻接关系,将入度为0的元素入队，
 * 然后把跟其有邻接关系指向的节点入度减一，若入度为0，则将此节点加入队列中
 * @author: xingzihao
 * @date: 2021/10/10
 **/
public class CourseSchedule {
}

//BFS
class CourseScheduleSolution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 解题思路：
        // 问题抽象：判断课程安排关系是否为有向无环图，拓扑排序
        // BFS: 构造入度表和邻接关系,将入度为0的元素入队，
        // 然后把跟其有邻接关系指向的节点入度减一，若入度为0，则将此节点加入队列中
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // 初始化邻接矩阵
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<Integer>());
        }

        // 构造入度表和邻接矩阵
        for(int[] node : prerequisites){
            indegree[node[0]]++;
            adjacency.get(node[1]).add(node[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 将节点入度为0的入队
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        // BFS遍历
        while(!queue.isEmpty()){
            int node = queue.poll();
            numCourses--;
            for(int v : adjacency.get(node)){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return numCourses == 0;
    }
}