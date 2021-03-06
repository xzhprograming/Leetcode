/**
 * @author xing
 * @create 2021-03-04 23:07
 */
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;  //当为len偶数会向下取整，即长度为4时，（3+0）/2 =1
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {  查找范围左闭[0, mid), mid上面已经判断过了
                if (nums[0] <= target && target < nums[mid]) { //不使用等号会出现漏解的情况
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) { //注意要添加等号查找范围右闭(mid, n-1]，否则会漏解
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 1));
    }
}
