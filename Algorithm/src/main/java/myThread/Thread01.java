package myThread;


import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//两个线程轮流打印 1~100
public class Thread01 {
    public static void main(String[] args) {
       Thread01PrintReentrantLock threadPrint1 = new Thread01PrintReentrantLock(100);
        new Thread(threadPrint1::printOdd, "Odd").start();
        new Thread(() -> {
            threadPrint1.printEven();
        }, "Even").start();

        /*Thread01PrintSynchronized threadPrint2 = new Thread01PrintSynchronized(100);
        new Thread(threadPrint2::PrintOdd,"Odd").start();
        new Thread(threadPrint2::PrintEven,"Even").start();*/
    }

}

class Thread01PrintReentrantLock {
    private ReentrantLock lock = new ReentrantLock();
    private Condition odd = lock.newCondition();
    private Condition even = lock.newCondition();
    private int count = 1;
    private int max;

    public Thread01PrintReentrantLock(int max) {
        this.max = max;
    }

    public void printOdd() {
        while (count <= max) {
            lock.lock();
            try {
                while (count % 2 == 0) {
                    try {
                        odd.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (count <= max) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    even.signal();
                }
            } finally {
                lock.unlock();
            }
        }

    }

    public void printEven() {
        while (count <= max) {
            lock.lock();
            try {
                while (count % 2 == 1) {
                    try {
                        even.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (count <= max) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    odd.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}


//用synchronized 解决
class Thread01PrintSynchronized {
    private Object lock = new Object();
    private int max;
    private int count = 1;

    public Thread01PrintSynchronized(int max){
        this.max = max;
    }

    public void PrintOdd(){
        print(true);
    }

    public void PrintEven(){
        print(false);
    }

    public void print(boolean flag){
        while(count<=max){
            synchronized (lock){
                while(flag == (count%2==0) && count<=max){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(count<=max){
                    System.out.println(Thread.currentThread().getName()+": "+count++);
                    lock.notify();
                }
            }
        }
    }
}