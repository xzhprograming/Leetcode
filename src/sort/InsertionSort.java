package sort;

/**
 * @author xingzihao
 * @description
 * @create 2025-03-20 23:26
 **/
public class InsertionSort {
    // 插入排序
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            // 记录当前i位置的值
            int key = array[i];

            // 从后向前找到插入位置
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            // 要插入的位置就j+1
            array[j + 1] = key;
        }
    }

    /**
     * 元素交换
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        insertionSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
