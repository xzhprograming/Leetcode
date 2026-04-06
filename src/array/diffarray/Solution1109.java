package array.diffarray;

/**
 * @author xingzihao
 * @description
 *
 * 1109. 航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着
 * 在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * 示例 2：
 *
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * @create 2026-04-06 20:31
 **/
public class Solution1109 {

    /**
     * 使用差分数组解决区间加法问题
     * 
     * 差分数组原理：
     * 1. 差分数组 diff[i] = nums[i] - nums[i-1]（相邻元素的差值）
     * 2. 对原数组区间 [left, right] 增加 val，等价于：
     *    - diff[left] += val（从 left 开始都增加了 val）
     *    - diff[right+1] -= val（从 right+1 开始不再增加，需要减回去）
     * 3. 最后通过前缀和还原：nums[i] = nums[i-1] + diff[i]
     * 
     * 优势：将区间修改的时间复杂度从 O(k) 优化到 O(1)
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if(bookings == null || bookings.length == 0){
            return new int[0];
        }
        
        // 步骤1：构建差分数组（初始全为0）
        int[] diff = new int[n];
        
        // 步骤2：处理每条预订记录，更新差分数组
        for(int[] booking : bookings){
            int first = booking[0];  // 起始航班（从1开始）
            int last = booking[1];   // 结束航班（从1开始）
            int seats = booking[2];  // 预订座位数
            
            // 核心操作：对区间 [first, last] 增加 seats
            // 注意：题目中航班编号从1开始，数组索引从0开始
            diff[first - 1] += seats;  // 从 first 位置开始增加 seats
            
            // 如果 last 不是最后一个航班，需要在 last+1 位置减去 seats
            // 这样才能保证只有 [first, last] 区间内的航班增加了 seats
            if(last < n){
                diff[last] -= seats;  // last 对应数组索引是 last-1，所以 last 就是 last+1-1
            }
        }
        
        // 步骤3：通过前缀和还原最终结果数组
        int[] res = new int[n];
        res[0] = diff[0];  // 第一个元素直接赋值
        
        for(int i = 1; i < n; i++){
            // 当前位置的值 = 前一个位置的值 + 差分值
            res[i] = res[i - 1] + diff[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution1109 solution = new Solution1109();
        
        // 测试用例1
        int[][] bookings1 = {{1,2,10},{2,3,20},{2,5,25}};
        int n1 = 5;
        int[] result1 = solution.corpFlightBookings(bookings1, n1);
        System.out.print("测试结果1: [");
        for(int i = 0; i < result1.length; i++){
            System.out.print(result1[i]);
            if(i < result1.length - 1) System.out.print(",");
        }
        System.out.println("]");
        // 期望输出: [10, 55, 45, 25, 25]
        
        // 测试用例2
        int[][] bookings2 = {{1,2,10},{2,2,15}};
        int n2 = 2;
        int[] result2 = solution.corpFlightBookings(bookings2, n2);
        System.out.print("测试结果2: [");
        for(int i = 0; i < result2.length; i++){
            System.out.print(result2[i]);
            if(i < result2.length - 1) System.out.print(",");
        }
        System.out.println("]");
        // 期望输出: [10, 25]
    }
}
