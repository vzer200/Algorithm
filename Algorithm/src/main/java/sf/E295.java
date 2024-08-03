package sf;

import heap.Heap;

public class E295 {
    private Heap left = new Heap(10,true);
    private Heap right = new Heap(10,false);

    public void addNum(int num) {
        //添加的元素num
        if(left.size()==right.size()){
            //优先添加左边大顶堆
            right.offer(num);
            left.offer(right.poll());

        }else {
            left.offer(num);
            right.offer(left.poll());
        }


    }

    public double findMedian() {

        if (left.size()>right.size()){
            return left.peek();
        }else {
            return (left.peek() + right.peek()) / 2.0;
        }

    }

}
