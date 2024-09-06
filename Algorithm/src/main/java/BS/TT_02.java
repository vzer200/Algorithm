package BS;

import java.util.Arrays;

public class TT_02 {
    // 计算逆序对数量的方法

    public static int InversionCount(long[] timeSequence) {
        return mergeSort(timeSequence, 0, timeSequence.length - 1);
    }

    // 归并排序并统计逆序对
    private static int mergeSort(long[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = (left + right) >>> 1;

            // 统计左半部分的逆序对
            count += mergeSort(arr, left, mid);

            // 统计右半部分的逆序对
            count += mergeSort(arr, mid + 1, right);

            // 统计跨越两个部分的逆序对
            count += mergeCount(arr, left, mid, right);
        }

        return count;
    }

    private static int mergeCount(long[] arr, int left, int mid, int right) {
        long[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        long[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left, res = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                res += (mid + 1) - (left + i);
            }
        }

        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        // 示例输入
        long[] arr = {1627890123, 1627890125, 1627890124, 1627890127, 1627890126};


        // 调用方法计算逆序对数量
        int inversions = InversionCount(arr);
        System.out.println("逆序对数量: " + inversions);  // 输出：2
    }
}
