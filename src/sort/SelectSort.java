package sort;

/**
 * @author xingzihao
 * @description
 * @create 2025-03-20 23:25
 **/
public class SelectSort {

    // 选择排序
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换 array[minIndex] 和 array[i]
            swap(array, minIndex, i);
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
        selectionSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
