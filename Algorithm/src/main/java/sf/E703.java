package sf;

import heap.MinHeap;

public class E703 {


    private MinHeap minHeap;
    public void KthLargest(int k, int[] nums) {
        minHeap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        if (!minHeap.isFull()){
            minHeap.offer(val);
        }else if (minHeap.peek()<val){
            minHeap.replace(val);
        }
        return minHeap.peek();
    }

}
