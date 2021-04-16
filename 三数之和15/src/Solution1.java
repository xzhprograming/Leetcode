import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xing
 * @create 2021-04-13 20:34
 */
public class Solution1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排序
        Arrays.sort(nums);

        int len = nums.length;

        int c = 0;

        for(int i = 0; i < len; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            c = -nums[i];
            // 定义双指针
            int left = i + 1;
            int right = len - 1;

            // 计算两数之和为c的元素
            while(left < right){
                if(nums[left] + nums[right] > c){
                    // 右指针左移
                    right--;
                }
                // 左指针右移
                else if(nums[left] + nums[right] < c){
                    left++;
                }
                else{// 找到和为c的两个元素
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    tmp.add(nums[i]);
                    ans.add(new ArrayList(tmp));
                    // 找到下个与left不相等的元素
                    int temp = nums[left];
                    while(left < right && nums[++left] == temp);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1};
        System.out.println(threeSum(nums));
    }
}
