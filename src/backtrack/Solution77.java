package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * @create 2025-03-07 00:16
 **/
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, 1, k, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int n, int start, int k, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i<= n; i++){
            list.add(i);
            backtrack(n, i + 1, k, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
