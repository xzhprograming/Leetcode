import java.util.*;

/**
 * 方法一：滑动窗口
 * 思路和算法
 *
 * 我们先用一个例子来想一想如何在较优的时间复杂度内通过本题。
 *
 * 我们不妨以示例一中的字符串 abcabcbb 为例，找出 从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。
 * 对于示例一中的字符串，我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：
 *
 * 以 \texttt{(a)bcabcbb}(a)bcabcbb 开始的最长字符串为 \texttt{(abc)abcbb}(abc)abcbb；
 * 以 \texttt{a(b)cabcbb}a(b)cabcbb 开始的最长字符串为 \texttt{a(bca)bcbb}a(bca)bcbb；
 * 以 \texttt{ab(c)abcbb}ab(c)abcbb 开始的最长字符串为 \texttt{ab(cab)cbb}ab(cab)cbb；
 * 以 \texttt{abc(a)bcbb}abc(a)bcbb 开始的最长字符串为 \texttt{abc(abc)bb}abc(abc)bb；
 * 以 \texttt{abca(b)cbb}abca(b)cbb 开始的最长字符串为 \texttt{abca(bc)bb}abca(bc)bb；
 * 以 \texttt{abcab(c)bb}abcab(c)bb 开始的最长字符串为 \texttt{abcab(cb)b}abcab(cb)b；
 * 以 \texttt{abcabc(b)b}abcabc(b)b 开始的最长字符串为 \texttt{abcabc(b)b}abcabc(b)b；
 * 以 \texttt{abcabcb(b)}abcabcb(b) 开始的最长字符串为 \texttt{abcabcb(b)}abcabcb(b)。
 * 发现了什么？如果我们依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的！这里的原因在于，假设我们选择字符串中的第 kk 个字符作为起始位置，
 * 并且得到了不包含重复字符的最长子串的结束位置为 r_kr
 *
 * 。那么当我们选择第 k+1 个字符作为起始位置时，
 *
 * 注：重点优化：首先从 k+1 到 r_kr 的字符显然是不重复的，并且由于少了原本的第 k 个字符，我们可以尝试继续增大 r_kr，直到右侧出现了重复字符为止。

 * 这样以来，我们就可以使用「滑动窗口」来解决这个问题了：
 * 我们使用两个指针表示字符串中的某个子串（的左右边界）。其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的 r_kr
 * 在每一步的操作中，我们会作为将左指针向右移动一格，表示 我们开始枚举下一个字符起始位置，然后我们可以不断地向右移动右指针，
 * 但需要保证这两个指针对应的子串中没有重复的字符。在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；
 * <p>
 * 在枚举结束后，我们找到的最长的子串的长度即为答案。
 *
 * @Author xing
 * @TIME 2021-01-31 22:02
 */
public class lengthOfLongestSubstringTest {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int ans = 0;
        int right = -1;  // 此时右指针为移动，设置其位置为-1
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                // 左指针向右移动一格后，移除一个字符
                set.remove(s.charAt(i - 1));
            }

            while (right + 1< s.length() && !set.contains(s.charAt(right + 1))) {
                // 如果集合中不存在此字符
                set.add(s.charAt(right + 1));
                right++;  // 右指针右移
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串,即做指针每前移一次都要更新最长子串的长度
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = -1;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)));  // 更新左指针位置
            }
            map.put(s.charAt(i), i);// 哈希表记录
            ans = Math.max(i - left, ans); // 更新结果
        }
        return ans;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int size = 0;
        List<Character> chars = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            chars.add(s.charAt(i));
            for (int j = i + 1; j <= s.length(); j++){
                // j == n 表示直到最后一个字符都没有重复
                if(j == s.length() || chars.contains(s.charAt(j))){
                    size = Math.max(j - i, size);
                    chars.clear();
                    break;
                } else {
                    chars.add(s.charAt(j));
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        String s = new String("vdf");
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
