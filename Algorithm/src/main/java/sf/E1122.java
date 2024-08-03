package sf;

import java.util.ArrayList;
import java.util.List;

public class E1122 {
    //数组的相对排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //计数排序：将原始数组的元素放入新数组，原始数组的值为新数组的索引，原始数组的值出现的次数为新数组的值
        int[] count = new int[1001];
        for (int i : arr1) {//i代表原始数组的值
            count[i]++;//将原始数组的值出现的次数添加到新数组的值
        }
        List<Integer> list = new ArrayList<>();
        //此时count数组中已经添加了对应的元素
        //目前是要让元素按照arr2的排序规则来进行排序
        //arr2是原始数组的子集
        for (int i = 0; i < arr2.length; i++) {
            int i1 = arr2[i];
            int num = count[i1];
            for (int i2 = 0; i2 < num; i2++) {
                list.add(i1);
            }
            count[i1] = 0;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]>0){
                list.add(i);
                count[i]--;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }


    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        //计数排序：将原始数组的元素放入新数组，原始数组的值为新数组的索引，原始数组的值出现的次数为新数组的值
        int[] count = new int[1001];
        for (int i : arr1) {//i代表原始数组的值
            count[i]++;//将原始数组的值出现的次数添加到新数组的值
        }
        List<Integer> list = new ArrayList<>();
        //此时count数组中已经添加了对应的元素
        //目前是要让元素按照arr2的排序规则来进行排序
        //arr2是原始数组的子集
        int[] reslut = new int[arr1.length];
       int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (count[arr2[i]] > 0) {//i为索引
                reslut[k++] = arr2[i];
                count[arr2[i]]--;
            }
        }
       /* for (int i : arr2) {//i为元素的值
            while (count[i] > 0) {
                reslut[k++] = i;
                count[i]--;
            }
        }*/
        for (int i = 0; i < count.length; i++) {
            while (count[i]>0){
                reslut[k++] = i;
                count[i]--;
            }
        }


        return reslut;
    }

}
