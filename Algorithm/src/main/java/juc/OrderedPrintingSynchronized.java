package juc;


import java.util.Arrays;

public class OrderedPrintingSynchronized {
    private int max = 100;
    private int count = 0;

    private final Object lock = new Object();
    private final int threadCount;
    public OrderedPrintingSynchronized(int threadCount){
        this.threadCount = threadCount;
    }

    public void print(int threadId){
        synchronized (lock){
            while (count<max){
                while(count%threadCount!=threadId){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if (count<=max){

                    System.out.println("threadId:"+threadId+"- "+count);
                    count++;
                    lock.notifyAll();
                }
            }
        }

    }

    public static void main(String[] args) {
        OrderedPrintingSynchronized o = new OrderedPrintingSynchronized(3);
        for (int i = 0; i < 3; i++) {
            int x = i;
            new Thread(() -> o.print(x)).start();
        }
    }

}