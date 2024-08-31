package sf;

import java.util.PriorityQueue;

public class E215 {

    public static void main(String[] args) {
        int[] sum = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int kthLargest = findKthLargest(sum, k);
        System.out.println(kthLargest);

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1-o2);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0 ;i<k-1;i++){
            queue.poll();
        }
        return queue.poll();
    }

}
