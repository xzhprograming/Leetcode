package dp;

/**
 * @author xingzihao
 * @description
 * 5. 最长回文子串
 *
 * 思路：
 * 1. 遍历每一个位置，以该位置为中心，向两边扩散，判断是否是回文串，如果是，则更新最长回文串的长度
 * 2. 记录每个最大子串的起始和结束位置，最终结果为s.substring(begin, end + 1)
 *
 * @create 2025-03-22 16:34
 **/
public class Solution5 {
    public String longestPalindrome(String s) {
        // 对每一个位置，进行中心扩散，判断是否符合回文串的条件，最后取回文串长度的最大值
        // 包括奇数位置扩散和偶数位置扩散

        int ans = 0;
        char[] arr = s.toCharArray();
        // 需要记录最长回文子串的起始和结束位置
        int begin = 0;
        int end = 0;
        for(int i  = 0; i < arr.length; i++){
            // 奇数扩散
            int size1 = center(arr, i, i);

            // 偶数扩散
            int size2 = center(arr, i, i + 1);

            int max = Math.max(size1, size2);

            // 此处可以优化begin的取值
//            if(end - begin + 1 < max){
//                if(size1 > size2){
//                    end = i + max / 2;
//                    begin = i - max / 2;
//                } else {
//                    end = i + max / 2;
//                    begin = i - max / 2 + 1;
//                }
//            }
            // end的取值逻辑相同
            // 对于begin,若size1>size2,那么max必然为奇数，则i-max/2 = i - (max - 1)/2
            // 对于begin,若size1<=size2,那么max必然为偶数，则i-max/2 + 1 = i - (max - 1)/2
            if(end - begin + 1 < max){
                end = i + max / 2;
                begin = i - (max - 1) / 2;
            }

        }

        return s.substring(begin, end + 1);

    }

    public int center(char[] arr, int left, int right){
        while(left >= 0 && right < arr.length && arr[left] == arr[right]){
            left--;
            right++;
        }
        return right - left - 1;
    }



    /**
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
    public String longestPalindrome1(String s) {
        int n = s.length();
        if (n < 2)
            return s;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            // 长度为1的串默认都是回文串
            dp[i][i] = true;

        int maxlen = 1; //最短回文子串长度为1
        int begin = 0;

        // 遍历0...1, 0...2,0...3的串，依次得到最长回文串
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                // i位置和j位置字符不相等，则dp[i][j]不是回文串
                // 若相等，如果长度为1或2，那么必为回文串，否则，缩小子串范围，等于其缩小后的子串值，即dp[i][j] = dp[i + 1][j - 1];
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] == true && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }

}
