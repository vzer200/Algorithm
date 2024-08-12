package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//问题描述：写两个线程打印 1-100，⼀个线程打印奇数，⼀个线程打印偶数。
public class ThreadE01 {
    public static void main(String[] args) {
        ThreadE01ReentrantLock threadE01ReentrantLock = new ThreadE01ReentrantLock(100);
        new Thread(threadE01ReentrantLock::printOdd,"Odd").start();
        new Thread(threadE01ReentrantLock::printEven,"Even").start();
    }
}

class ThreadE01ReentrantLock{
    private boolean flag = true;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition= lock.newCondition();
    private int max;
    private int count = 1;

    public ThreadE01ReentrantLock(int max){
        this.max = max;
    }

    public void printOdd(){
        print(true);
    }
    public void printEven(){
        print(false);
    }

    public void print(boolean isFlag) {
        while (count <= max) {
            lock.lock();
            try {
                while (isFlag != flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (count > max) {
                    condition.signal();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + ": " + count++);
                flag = !flag;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
