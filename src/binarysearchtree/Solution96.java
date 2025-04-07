package binarysearchtree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingzihao
 * @description 96. 不同的二叉搜索树
 * @create 2025-03-02 19:52
 **/
public class Solution96 {
    public int numTrees1(int n) {

        // 计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
        //G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
        // F(i,n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数

        // 当序列长度为 1（只有根）或为 0（空树）时，只有一种情况，即：
        // G(0)=1,G(1)=1
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // 假设序列为[1,2,3,4,5,6,7]，以3为根节点，则左子树为[1,2],右子树为[4,5,6,7]构建BST
        // F(3,7) = G(2)*G(4);
        // F(i,n)=G(i−1) * G(n−i)
        // G(n)= (求和i = 1...n) G(i−1) * G(n−i)

        for (int len = 2; len <= n; len++) {
            // G(n)= (求和i = 1...n) G(i−1) * G(n−i)
            for (int i = 1; i <= len; i++) {
                dp[len] += dp[i - 1] * dp[len - i];
            }
        }
        return dp[n];
    }


    // 递归解法
    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        //如果只有0，或者1个节点，则可能的子树情况为1种
        if (n == 0 || n == 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            //当用i这个节点当做根节点时

            //左边有多少种子树
            int leftNum = numTrees(i - 1);

            //右边有多少种子树
            int rightNum = numTrees(n - i);

            //乘起来就是当前节点的子树个数
            count += leftNum * rightNum;
        }

        map.put(n, count);

        return count;
    }


    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        int i = solution96.numTrees(7);
        System.out.println(i);
    }
}
