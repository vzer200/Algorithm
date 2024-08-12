package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//两个线程交替打印出a1b2c3.....z26
public class Thread07 {

    public static void main(String[] args) {
        Thread07PrintSynchronized thread07PrintReentrantLock = new Thread07PrintSynchronized();
        new Thread(() -> {
            thread07PrintReentrantLock.printLetter(true);
        }, "Letter").start();
        new Thread(() -> {
            thread07PrintReentrantLock.printNumber(false);
        }, "Number").start();
    }

}


class Thread07PrintReentrantLock {
    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionLetter = lock.newCondition();
    private Condition conditionNumber = lock.newCondition();
    private boolean flag = true;
    private char ch = 'a';


    public void printLetter(boolean isFlag) {
        lock.lock();
        try {
            while (ch <= 'z') {
                while (flag != isFlag) {
                    try {
                        conditionLetter.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print(ch++);
                flag = !flag;
                conditionNumber.signal();
            }
        } finally {
            lock.unlock();
        }
    }


    public void printNumber(boolean isFlag) {
        lock.lock();
        try {
            for (int i = 1; i <= 26; i++) {
                while (flag != isFlag) {
                    try {
                        conditionNumber.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print(i);
                flag = !flag;
                conditionLetter.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}


//两个线程交替打印出a1b2c3.....z26
class Thread07PrintSynchronized {
    private boolean flag = true;
    private char ch = 'a';

    public synchronized void printLetter(boolean isFlag) {
        while (ch <= 'z') {
                while (flag != isFlag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print(ch++);
                flag = !flag;
                notify();

        }

    }

    public synchronized void printNumber(boolean isFlag) {
        for(int i = 1;i<=26;i++){
                while(flag!=isFlag){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print(i);
                flag = !flag;
                notify();
        }
    }


}