package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//问题描述：写三个线程打印 "ABC"，⼀个线程打印 A，⼀个线程打印 B，⼀个线程打印 C，
//⼀共打印 10 轮
public class ThreadE02 {
    public static void main(String[] args) {
        ThreadE02ReentrantLock threadE02ReentrantLock = new ThreadE02ReentrantLock(3);
        new Thread(()->{
            threadE02ReentrantLock.print(0);
        },"ThreadA").start();
        new Thread(()->{
            threadE02ReentrantLock.print(1);
        },"ThreadB").start();
        new Thread(()->{
            threadE02ReentrantLock.print(2);
        },"ThreadC").start();
    }
}

class ThreadE02ReentrantLock {
    private ReentrantLock lock = new ReentrantLock();
    private Condition[] conditions = new Condition[3];
    private int round = 1;
    private int roundTotal;
    private int turn = 0;

    public ThreadE02ReentrantLock(int roundTotal) {
        for (int i = 0; i < 3; i++) {
            conditions[i] = lock.newCondition();
        }
        this.roundTotal = roundTotal;
    }

    public void print(int i) {
        while (round <= roundTotal) {
            lock.lock();
            try {
                while (i != turn) {
                    try {
                        conditions[i].await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if(turn==0){
                    round++;
                }

                System.out.println(Thread.currentThread().getName()+": " + (char) (turn + 'A'));
                turn = (turn + 1) % 3;
                conditions[turn].signal();
            } finally {
                lock.unlock();
            }
        }

    }
}
