package sort;

/**
 * @author xingzihao
 * @description
 * @create 2025-03-20 23:46
 **/
public class QuickSort {

    // 快速排序
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                // 交换 array[i] 和 array[j]
                swap(array, low, j);
                low++;
            }
        }

        // 交换 array[i+1] 和 array[high] (or pivot)
        swap(array, low, high);

        return low;
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
        int[] array = {1,5,7,9,10,4, 8};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
