import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
* 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
*
* 示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
* 示例 2：

输入：nums = []
输出：[]

* 示例 3：

输入：nums = [0]
输出：[]
* */

//排序 + 双指针
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        //先排序
        Arrays.sort(nums); // (nlogn)
        List<List<Integer>> ans = new ArrayList<>();
        //枚举first
        for(int first = 0; first < n; first++){
            // 需要和上一次枚举的数不相同,即去除可能重复的三元组
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1; //初始化第三个数的位置
            int target = -nums[first]; // 初始化目标值，即第二个数和第三个数之和
//            双指针
            for (int second = first + 1; second < n;second++){
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                // 注：需要保证 second 的指针在 third 的指针的左侧,因为是在排序后的数组中进行的操作
                // 若第二个和第三个数和大于目标值，则第三个数位置前移进行寻找
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 second 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if(nums[second] + nums[third] == target){
//                    List<Integer> tempList = new ArrayList<Integer>(3);
//                    tempList.add(nums[first]);
//                    tempList.add(nums[second]);
//                    tempList.add(nums[third]);
//                    ans.add(tempList);
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return ans;
    }
//    复杂度分析
//
//    时间复杂度：O(N^2)O(N2)，其中 NN 是数组 \textit{nums}nums 的长度。
//
//    空间复杂度：O(\log N)O(logN)。我们忽略存储答案的空间，额外的排序的空间复杂度为 O(\log N)O(logN)。
//    然而我们修改了输入的数组 \textit{nums}nums，在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了 \textit{nums}nums 的副本并进行排序，空间复杂度为 O(N)O(N)。

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.threeSum(nums);
        System.out.println(ans.toString());
    }
}
