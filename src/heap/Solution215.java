package heap;

/**
 * @author xingzihao
 * @description
 * 215. 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @create 2025-03-29 17:03
 **/
public class Solution215 {

    //寻找第k大的元素，这里要注意数组的索引是从0开始的
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return sort(nums, 0 , len - 1, len - k);
    }

    //排序从小到大的排列，第2大就是nums.length - 2的位置的元素
    private int sort(int[] arr, int left, int right, int x) {
        //返回的是目标值的索引位置
        int index = partition(arr, left, right);

        if(index == x) {
            return arr[index];
        } else if(x < index) { //在目标值的左边
            return sort(arr, left, index -1 , x);
        } else {
            return sort(arr, index + 1, right, x);
        }
    }

    // 寻找基准点
    private int partition(int[] arr, int left, int right) {
        //假设基准值为左边界的值
        int pivot = arr[right];
        int i = left; //从左向右找比基准点大的
        int j = right; //从右向左找比基准点小的的
        while(i < j) {
            //找不到就继续加
            // 这一步需要先执行，因为如果最后找到划分的位置在right,i需要到达right的位置，完成最后的交换
            while(i < j && arr[i] <= pivot) {
                i++;
            }
            //找不到就继续减
            while(i < j && arr[j] >= pivot) {
                j--;
            }
            if(i < j){
                swap(arr, i, j); //找到了就交换
            }
        }
        swap(arr, i, right); //最后还是要交换一次基准点与i位置的元素
        return i; //返回基准点的位置
    }

    // 寻找基准点
    private int partition1(int[] arr, int left, int right) {
        //假设基准值为右边界的值
        int pivot = arr[right];
        //找到最后切分插入位置
        int index = left;

        for(int i = left; i < right; i++){
            // 找到比pivot小的数，与切分位置交换，即将小的数移动到切分位置的左边
            if(arr[i] < pivot){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, index, right); //最后还是要交换一次基准点与i位置的元素
        return index; //返回基准点的位置
    }

    //交换数组的两个索引位置的值
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        Solution215 solution215 = new Solution215();
        int res = solution215.findKthLargest(nums, k);
        System.out.println(res);
    }

}
