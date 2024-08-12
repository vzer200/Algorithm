package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 三个线程交替顺序打印出 1-100
public class Thread02 {

    public static void main(String[] args) {
        /*Thread02PrintReentrantLock thread02PrintReentrantLock = new Thread02PrintReentrantLock(100);

        new Thread(() -> {
            while (thread02PrintReentrantLock.getCount() <= thread02PrintReentrantLock.getMax()) {
                thread02PrintReentrantLock.print(0);
            }
        }, "Thread1").start();

        new Thread(() -> {
            while (thread02PrintReentrantLock.getCount() <= thread02PrintReentrantLock.getMax()) {
                thread02PrintReentrantLock.print(1);
            }
        }, "Thread2").start();

        new Thread(() -> {
            while (thread02PrintReentrantLock.getCount() <= thread02PrintReentrantLock.getMax()) {
                thread02PrintReentrantLock.print(2);
            }
        }, "Thread3").start();*/

        Thread02PrintSynchronized thread02PrintSynchronized = new Thread02PrintSynchronized(100);
        new Thread(() -> {
            thread02PrintSynchronized.print(0);
        }, "Thread1").start();
        new Thread(() -> {
            thread02PrintSynchronized.print(1);
        }, "Thread2").start();
        new Thread(() -> {
            thread02PrintSynchronized.print(2);
        }, "Thread3").start();


    }
}

class Thread02PrintReentrantLock {
    private ReentrantLock lock = new ReentrantLock();
    private final Condition[] conditions = new Condition[3];
    private int max;
    private int count = 1;
    private int turn = 0;

    public Thread02PrintReentrantLock(int max) {
        this.max = max;
        for (int i = 0; i < 3; i++) {
            conditions[i] = lock.newCondition();
        }
    }

    public void print(int id) {
        lock.lock();
        try {
            //在这里加上count<=100就会停止了
            while (count <= 100 && turn != id) {
                try {
                    conditions[id].await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (count > max) {
                conditions[(turn + 1) % 3].signal();// 唤醒下一个线程并退出
                return;
            }
            System.out.println(Thread.currentThread().getName() + ": " + count++);
            turn = (turn + 1) % 3;
            conditions[turn].signal();


        } finally {
            lock.unlock();
        }
    }


}

class Thread02PrintSynchronized {
    private int turn = 0;
    private Object lock = new Object();
    private int count = 1;
    private int max;

    public Thread02PrintSynchronized(int max) {
        this.max = max;
    }

    public void print(int id) {
        while (count <= max) {
            synchronized (lock) {
                while (turn != id) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //加上停止逻辑
                if (count > max) {
                    turn = (turn + 1) % 3;
                    lock.notify();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + ": " + count++);
                turn = (turn + 1) % 3;
                lock.notifyAll();
            }
        }
    }

}