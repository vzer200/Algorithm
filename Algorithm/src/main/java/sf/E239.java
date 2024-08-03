package sf;


import heap.MaxHeap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class E239 {
    //利用双端队列手动实现单调队列
    /*
      用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
      单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
     */

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        int k = 2;
        int[] ints = maxSlidingWindow(nums, k);
        //System.out.println()方法默认会将数组对象转换为字符串表示形式，而数组对象的默认字符串表示形式是其内存地址。
        // 需要加Arrays.toString
        System.out.println(Arrays.toString(ints));

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for(int i = 0;i<k;i++){
            while(!queue.isEmpty()&&queue.peekLast()<nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
        }
        result[0] = nums[queue.peekFirst()];

        for(int j = k; j<nums.length;j++){
            int left = j - k + 1;
            if(left>queue.peekFirst()){
                queue.pollFirst();
            }
            while(!queue.isEmpty()&&queue.peekLast()<nums[j]){
                queue.pollLast();
            }
            queue.addLast(j);
            result[left] = nums[queue.peekFirst()];

        }


        return result;
    }




}
