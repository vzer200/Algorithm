package sf;

import heap.MaxHeap;

import java.util.*;

public class E347 {

    public static void main(String[] args) {
        int[] nums = {-1, -1};
        int k = 1;
        int[] ints = topKFrequent2(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //获得每个元素的大小和出现频率
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] array = new int[k];
        MaxHeap maxHeap = new MaxHeap(k);



         /* 请注意，增强for循环只能用于遍历实现了Iterable接口的集合类（例如List、Set等），
       而不能用于遍历没有实现Iterable接口的集合类（例如Map、Queue等）。
       因此，如果您需要遍历Map对象中的键值对，则需要使用entrySet()方法将其转换为一个Set集合，然后使用增强for循环进行遍历。*/



        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            maxHeap.offer(entry.getValue());
               //maxHeap.offer(entry.getValue());

        }
        for (int i = 0; i < k; i++) {
            //这是poll出来的是频率，需要把key给放入数组
            //maxHeap.poll()为空

            array[i] = map.get(maxHeap.poll());


        }


        return  array;
    }


    public static int[] topKFrequent2(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        // 根据map的value值，构建于一个大顶堆（o1 - o2: 小顶堆， o2 - o1 : 大顶堆）
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);

        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }


}
