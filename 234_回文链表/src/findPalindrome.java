/**
 * @author xing
 * @create 2021-03-07 12:52
 */
public class findPalindrome {
    public String palindrome(String str){
        int n = str.length();
        int left, right;
        if (n <= 1) // 长度小于1时必为回文串
            return str;
        right = n / 2;
        if(n % 2 == 0){ // 为偶数
            left = n / 2 - 1;
        }
        else //为奇数
            left = n / 2;
        return judge(str, left, right);
    }
    public String judge(String str, int l, int r){
        while (r < str.length() && l >= 0 && str.charAt(l) == str.charAt(r)){
            l--;
            r++;
        }
        return str.substring(l + 1, r);
    }

    public static void main(String[] args) {
        String a = "1211221321";
        findPalindrome fp = new findPalindrome();
        System.out.println(fp.palindrome(a));
    }
}
