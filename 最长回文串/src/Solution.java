/**
 * @Author xing
 * @TIME 2021-02-03 8:57
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babababad"));
    }

    public String longestPalindrome(String s) {
        /*
    若将i，j分别指向字符串的头尾，则是s[i]!=s[j]，则其不为回文串
    若s[i]==s[j],则将i前进一步，j后退一步，判断其子串是否为回文串，
    即下一次的状态与上一次的状态有关系，则使用动态转移，即将一个无结果小规模的问题，转化为
    一个有结果的大规模的问题。
    状态转移方程：
    dp[i][j] = (s[i] == s[j]) && dp[i][j] == dp[i+1][j-1]
    边界条件：即子串的长度为0，即(j-1) == (i+1)
    (j -1) - (i + 1) < 1,整理得j - i < 3
    if(s[i] == s[j]){
    if (j - i < 3)
        dp[i][j] == true;
    else
        dp[i][j] == dp[i+1][j-1]
    }
     */
        int n = s.length();
        if (n < 2)
            return s;
        //初始化状态转移数组,对角线元素置为true
        boolean[][] dp = new boolean[n][n];  // 初始化数组默认为false
        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        int maxlen = 1;
        int begin = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                // j- i + 1 为当前回文子串长度 ,其长度需> 1
                if (dp[i][j] == true && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }

}
