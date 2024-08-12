package myThread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//计数累加怎么线程安全，可以怎么实现，100个线程，每个线程累加100次
public class Thread04 {
    private static AtomicInteger counter   = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.submit(()->{
                for (int i1 = 0; i1 < 100; i1++) {
                    counter .incrementAndGet();
                }
            });
        }


        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Final counter value: " + counter .get());
    }

}

