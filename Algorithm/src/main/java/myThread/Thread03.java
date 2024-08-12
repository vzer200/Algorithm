package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//线程 A、B、C 分别打印 1，2，3 顺序执行 n(10) 次
public class Thread03 {

    public static void main(String[] args) {

        Thread03PrintSynchronized thread03PrintReentrantLock = new Thread03PrintSynchronized(10);
        new Thread(() -> {
                thread03PrintReentrantLock.print(0);
        }, "Thread-A").start();

        new Thread(() -> {
                thread03PrintReentrantLock.print(1);
        }, "Thread-B").start();

        new Thread(() -> {
                thread03PrintReentrantLock.print(2);
        }, "Thread-C").start();

    }

}

class Thread03PrintReentrantLock {

    private Condition[] conditions = new Condition[3];
    private int max;
    private int turn = 0;
    private ReentrantLock lock = new ReentrantLock();

    public Thread03PrintReentrantLock(int max) {
        this.max = max;
        for (int i = 0; i < 3; i++) {
            conditions[i] = lock.newCondition();
        }
    }

    public void print(int id) {
        for (int i = 0; i < max; i++) {
            lock.lock();
            try {
                while (turn != id) {
                    try {
                        conditions[id].await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + (id + 1));
                turn = (turn + 1) % 3;
                conditions[turn].signal();
            } finally {
                lock.unlock();
            }
        }

    }

}


class Thread03PrintSynchronized {

    private final Object lock = new Object();
    private int max;
    private int turn=0;

    public Thread03PrintSynchronized(int max){
        this.max = max;
    }

    public void print(int id){
        for (int i = 0; i < max; i++) {
            synchronized (lock){
                while (id!=turn){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+": "+(id+1));
                turn = (turn+1)%3;
                lock.notifyAll();
            }
        }
    }

}