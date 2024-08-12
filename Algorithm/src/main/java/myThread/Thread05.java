package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//两个线程交叉打印12A34B56C，多种实现方式（一个打印数字，一个打印字母）
public class Thread05 {

    public static void main(String[] args) {
        Thread05PrintReentrantLock thread05PrintSynchronized = new Thread05PrintReentrantLock();
        new Thread(thread05PrintSynchronized::printNumber).start();
        new Thread(thread05PrintSynchronized::printLetter).start();
    }

}




class Thread05PrintReentrantLock{
    private ReentrantLock lock = new ReentrantLock();
    private boolean flag = true;
    private Condition conditionNumber = lock.newCondition();
    private Condition conditionLetter = lock.newCondition();

    public void printNumber(){
        lock.lock();
        try {
            for (int i = 1; i <= 52; i+=2) {
                while(!flag){
                    try {
                        conditionNumber.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(i);
                System.out.print(i+1);
                flag = false;
                conditionLetter.signal();
            }

        }finally {
            lock.unlock();
        }

    }


    public void printLetter(){
        lock.lock();
        try {
            for (char c = 'A'; c <= 'Z'; c++) {
                while(flag){
                    try {
                        conditionLetter.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(c);
                flag = true;
                conditionNumber.signal();
            }

        }finally {
            lock.unlock();
        }
    }

}




class Thread05PrintSynchronized{
    private Object lock = new Object();
    private boolean flag = true; // 控制当前打印的内容

    public void printNumber() {
        for (int i = 1; i <= 52; i+=2) {
            synchronized (lock) {
                while (!flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(i);
                System.out.print(i+1);
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void printLetter() {
        for(char c = 'A'; c <= 'Z'; c++){
            synchronized (lock) {
                while (flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(c);
                flag = true;
                lock.notifyAll();
            }
        }
    }
}
