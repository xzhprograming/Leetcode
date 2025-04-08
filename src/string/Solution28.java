package string;

/**
 * @author xingzihao
 * @description
 *
 * 28. 找出字符串中第一个匹配项的下标
 *
 * 思路：
 * 1.暴力匹配，找到第一个相符的字符，匹配
 * @create 2025-04-08 23:52
 **/
public class Solution28 {

    public int strStr(String haystack, String needle) {


        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for(int j = 0; j < needle.length(); j++){
                    if(i + j >= haystack.length()){
                        break;
                    }
                    if(j != needle.length() - 1){
                        if(haystack.charAt(i + j) != needle.charAt(j)){
                            break;
                        }
                    } else {
                        if(haystack.charAt(i + j) == needle.charAt(j)){
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "mississippi";
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr(s, "sipp"));
    }
}
