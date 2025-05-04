/**
 * @author xingzihao
 * @description
 * LCR 170. 交易逆序对的总数
 * 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 *示例 1：
 *
 * 输入：record = [9, 7, 5, 4, 6]
 * 输出：8
 * 解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 *
 * 思路：分治思想
 * 参考归并排序的思想，将整个数组进行划分，转化为各子数组的排序问题
 * 将排序后的子数组分为左（left）右(right)数组，在向上合并左右数组的过程中，利用数组的有序性，记录存在的逆序对数
 *
 * @create 2025-05-04 15:05
 **/
public class Solution170 {

    //分： 不断将数组从中点位置划分开（即二分法），将整个数组的排序问题转化为子数组的排序问题；
    //治： 划分到子数组长度为 1 时，开始向上合并，不断将 较短排序数组 合并为 较长排序数组，直至合并至原数组时完成排序；
    int count = 0;
    public int reversePairs(int[] record) {
        mergeSort(record, 0, record.length - 1);
        return count;
    }

    public void mergeSort(int[] record, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(record, left, mid);
        mergeSort(record, mid + 1, right);

        int[] tmp = new int[right - left + 1];

        int l = left;
        int r = mid + 1;
        int index = 0;
        // 合并数组过程中记录逆序对个数
        while(l <= mid && r <= right){
            if(record[l] <= record[r]){
                tmp[index++] = record[l++];
            }else {
                // 向上合并时，记录长度
                count += mid - l + 1;
                tmp[index++] = record[r++];
            }
        }

        while(l <= mid){
            tmp[index++] = record[l++];
        }

        while(r <= right){
            tmp[index++] = record[r++];
        }
        for(int i = 0; i < tmp.length; i++){
            record[i + left] = tmp[i];
        }
    }
}
