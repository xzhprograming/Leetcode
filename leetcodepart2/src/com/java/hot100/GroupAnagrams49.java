package com.java.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 解题思路：
 * 1.由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
 * 2. 也可以将每个字符串中字母与字母出现的次数进行拼接，拼接后的字符串用作key，即可标识这些字母排列的原字符串的唯一性。
 * @author xing
 * @create 2021-04-24 23:15
 */
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 字符串作为键值，不同排列作为value
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);

            String key = new String(tmp);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList(map.values());
    }
}
