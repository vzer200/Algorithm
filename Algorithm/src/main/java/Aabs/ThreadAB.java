package Aabs;


//问题描述：写三个线程打印 "ABC"，⼀个线程打印 A，⼀个线程打印 B，⼀个线程打印 C，⼀共打印 n 轮。

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadAB {

}


//不好用
class ABCPrinter {
    private final int max;
    // ⽤来指示当前应该打印的线程序号，0-A, 1-B, 2-C
    private int turn = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    public ABCPrinter(int max) {
        this.max = max;
    }

    public void printA() {
        print("A", conditionA, conditionB);
    }

    public void printB() {
        print("B", conditionB, conditionC);
    }

    public void printC() {
        print("C", conditionC, conditionA);
    }

    private void print(String name, Condition currentCondition,
                       Condition nextCondition) {
        for (int i = 0; i < max; i++) {
            lock.lock();
            try {
                while (!((turn == 0 && name.charAt(0) == 'A') || (turn
                        == 1 && name.charAt(0) == 'B') || (turn == 2 && name.charAt(0) == 'C'))) {
                    currentCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + name);

                turn = (turn + 1) % 3;
                nextCondition.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        ABCPrinter abcPrinter = new ABCPrinter(10);
        new Thread(() -> {
            abcPrinter.printA();
        }).start();
        new Thread(() -> {
            abcPrinter.printB();
        }).start();
        new Thread(() -> {
            abcPrinter.printC();
        }).start();
    }
}