package myThread;

import java.util.concurrent.CountDownLatch;


//现在创建十个线程，每个线程有一个跑步的方法，如何保证十个线程同时执行跑步方法，保证赛跑的公平性?
public class Thread14 {
    public static void main(String[] args) throws InterruptedException {
        int numberOfRunners = 10;
        CountDownLatch readyLatch = new CountDownLatch(numberOfRunners);
        CountDownLatch startLatch = new CountDownLatch(1);

        for (int i = 0; i < numberOfRunners; i++) {
            new Thread(new Runner(readyLatch, startLatch)).start();
        }

        // 等待所有选手准备好
        readyLatch.await();

        // 所有线程准备好后，启动比赛
        System.out.println("All runners are ready. Get set... Go!");
        startLatch.countDown();  // 所有线程同时开始
    }
}
class Runner implements Runnable {
    private final CountDownLatch readyLatch;
    private final CountDownLatch startLatch;

    public Runner(CountDownLatch readyLatch, CountDownLatch startLatch) {
        this.readyLatch = readyLatch;
        this.startLatch = startLatch;
    }

    @Override
    public void run() {
        try {
            // 模拟选手准备
            System.out.println(Thread.currentThread().getName() + " is ready.");
            readyLatch.countDown();  // 选手准备好

            // 等待比赛开始信号
            startLatch.await();

            // 模拟跑步
            System.out.println(Thread.currentThread().getName() + " is running.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}