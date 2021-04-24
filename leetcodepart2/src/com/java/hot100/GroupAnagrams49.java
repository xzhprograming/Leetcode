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
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 *
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
