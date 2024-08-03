package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 合并两个有序数组 ( Leetcode 88 题改)
 */
public class E01Merge2SortedArray {

    public int[] smallestK1(int[] arr, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.sort(arr);
        int count = 1;
        for (int j : arr) {
            if (count <= k) {
                arrayList.add(j);
                count++;
            }
        }

        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public int[] smallestK2(int[] arr, int k) {

        PriorityQueue<Integer> q  = new PriorityQueue<>();
        for (int i : arr) q.add(i);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = q.poll();
        return ans;


    }

}
