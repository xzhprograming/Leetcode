package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzihao
 * @description
 *
 * 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字 1 到 9
 * 每个数字最多使用一次
 * 返回所有可能的有效组合，解集不能包含重复组合。
 *
 * 思路：
 * 1. 从 start 开始枚举候选数字，保证组合中的数字递增，从而避免重复组合。
 * 2. 每次选择一个数字后，将目标和 n 减去该数字，并从下一个数字继续搜索。
 * 3. 当组合长度为 k 且剩余目标和为 0 时，记录当前组合。
 *
 * @create 2026-06-28 15:47
 **/
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(k, n, ans, new ArrayList<>(), 1, 9);
        return ans;
    }

    public void backtrack(int k, int n, List<List<Integer>> ans, List<Integer> tmp, int start, int max){
        // 已经选择 k 个数且刚好凑出目标和，说明当前路径是一个有效组合
        if(tmp.size() == k && n == 0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start; i <= max; i++){
            // 候选数字递增，当前数字已超过剩余目标时，后续数字也无需继续尝试
            if(i > n){
                break;
            }
            tmp.add(i);
            // 每个数字只能使用一次，所以下一层从 i + 1 开始枚举
            backtrack(k, n - i, ans, tmp, i + 1, max);
            tmp.remove(tmp.size() - 1);
        }
    }
}
