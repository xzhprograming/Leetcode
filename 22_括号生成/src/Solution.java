import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 递归调试尽量用print，尽量不用单步调试
 * 方法一：暴力法
 * 思路：
 * 我们可以生成所有 2^{2n}个 '(' 和 ')' 字符构成的序列，然后我们检查每一个是否有效即可。
 * <p>
 * 算法：
 * 为了生成所有序列，我们可以使用递归。长度为 n 的序列就是在长度为 n-1 的序列前加一个 '(' 或 ')'。
 * <p>
 * 为了检查序列是否有效，我们遍历这个序列，并使用一个变量 balance 表示左括号的数量减去右括号的数量。
 * 如果在遍历过程中 balance 的值小于零，或者结束时 balance 的值不为零，那么该序列就是无效的，否则它是有效的。
 * 注意判断条件： 1.遍历过程中：balance < 0
 * 2.遍历结束时，balance == 0
 *
 * @author xing
 * @create 2021-03-02 14:03
 */
public class Solution {
    //方法一：暴力法
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateAll(new char[2 * n], 0, ans);
        return ans;
    }

    public void generateAll(char[] current, int pos, List<String> ans) {
        //若生成的长度current.length==当前位置pos，则可以判断当前生成的序列是否有效，否则继续添加括号，直到长度为pos
        if (current.length == pos) {
            if (vaild(current))
                ans.add(new String(current));
//            return;
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, ans);
            current[pos] = ')';
            generateAll(current, pos + 1, ans);
        }
    }

    public static boolean vaild(char[] current) {
//        char[] current = str.toCharArray();
        int balance = 0;
        for (char a : current) {
            if (a == '(')
                balance++;
            else
                balance--;
            if (balance < 0)
                return false;
        }
        return balance == 0;
    }

    //方法二：回溯法
//    思路和算法
//
//    方法一还有改进的余地：我们可以只在序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。
//    我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
//    如果左括号数量不大于 n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
//    且每个序列长度为2n
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(new StringBuilder(), 0, 0, ans, n);
        return ans;
    }

    //注：max
    public void backTrack(StringBuilder str, int open, int close, List<String> ans, int max) {
//        每个序列长度为2n
        if (str.length() == 2 * max) {
            ans.add(str.toString());
            System.out.println(ans.toString());
            return;
        }
        //左括号数量不大于 n，我们可以放一个左括号
        if (open < max) {
            str.append("(");
            backTrack(str, open + 1, close, ans, max);
            System.out.println("open backTrack:");
            System.out.println(ans.toString());
            str.deleteCharAt(str.length() - 1);
        }
//      如果右括号数量小于左括号的数量，我们可以放一个右括号
        if (close < open) {
            str.append(")");
            backTrack(str, open, close + 1, ans, max);
            System.out.println("close backTrack:");
            System.out.println(ans.toString());
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.generateParenthesis(3);
        List<String> ans1 = solution.generateParenthesis1(3);
//        for(String a : ans){
//            System.out.println(a);
//        }
//        Iterator<String> iterator = ans.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        System.out.println(ans.toString());
        System.out.println(ans1.toString());
    }
}
