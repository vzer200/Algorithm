package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//两个线程，一个打印abcd，一个打印1234，需求交替打印出a1b2c3d4a1b2c3d4 ； 打印10轮
public class Thread08 {

    public static void main(String[] args) {

        Thread08PrintSynchronized thread08PrintReentrantLock = new Thread08PrintSynchronized(2);
        new Thread(() -> {
            thread08PrintReentrantLock.printLetter(true);
        }, "Letter").start();
        new Thread(() -> {
            thread08PrintReentrantLock.printNumber(false);
        }, "Number").start();

    }

}


class Thread08PrintReentrantLock {
    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionLetter = lock.newCondition();
    private Condition conditionNumber = lock.newCondition();
    private boolean flag = true;
    private int totalRounds;
    private int round = 0;
    private char ch = 'a';
    private int i = 1;

    public Thread08PrintReentrantLock(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    public void printLetter(boolean isFlag) {
        lock.lock();
        try {
            while (round < totalRounds) {
                while (flag != isFlag) {
                    try {
                        conditionLetter.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print(ch);
                ch = ch == 'd' ? 'a' : (char) (ch + 1);
                flag = !flag;
                conditionNumber.signal();
                if (ch == 'a') { // 每当字母循环结束，意味着一轮完成
                    round++;
                }
            }
        } finally {
            lock.unlock();
        }
    }


    public void printNumber(boolean isFlag) {
        lock.lock();
        try {
            while (round < totalRounds) {
                while (flag != isFlag) {
                    try {
                        conditionNumber.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print(i);
                i = i == 4 ? 1 : i + 1;
                flag = !flag;
                conditionLetter.signal();
            }
        } finally {
            lock.unlock();
        }
    }

}


//两个线程，一个打印abcd，一个打印1234，需求交替打印出a1b2c3d4a1b2c3d4 ； 打印10轮
class Thread08PrintSynchronized {
    private Object lock = new Object();
    private int i = 1;
    private int round = 0;
    private int roundTotal;
    private boolean flag = true;
    private char ch = 'a';

    public Thread08PrintSynchronized(int roundTotal) {
        this.roundTotal = roundTotal;
    }

    public void printLetter(boolean isFlag) {
        while (round < roundTotal) {
            synchronized (lock) {
                while (flag != isFlag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print(ch);
                ch = ch == 'd' ? 'a' : (char) (ch + 1);
                flag = !flag;
                if(ch=='a') round++;
                lock.notify();
            }
        }
    }

    public void printNumber(boolean isFlag) {
        while (round < roundTotal) {
            synchronized (lock) {
                while (flag != isFlag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print(i);
                i = i == 4 ? 1 : i + 1;
                flag = !flag;
                lock.notify();
            }
        }
    }

}