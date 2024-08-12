package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//两个线程交替打印ABCD..Z字母，一个大写一个小写 目标输出：AbCdEfGhIjKlMnOpQrStUvWxYz
public class Thread06 {
    public static void main(String[] args) {
        Thread06PrintSynchronized thread06PrintReentrantLock = new Thread06PrintSynchronized();
        new Thread(()->{
            thread06PrintReentrantLock.printA();
        },"ThreadA").start();
        new Thread(thread06PrintReentrantLock::printa,"Threada").start();
    }

}


class Thread06PrintReentrantLock{
    private ReentrantLock lock = new ReentrantLock();
    private boolean flag = true;
    private Condition conditionA = lock.newCondition();
    private Condition conditiona = lock.newCondition();
    private char c = 'A';

    public void printA() {
        lock.lock();
        try {
            while (c <= 'Z') {
                while (!flag) {
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if(c<='Z')  System.out.print(c++);
                flag = false;
                conditiona.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void printa() {
        lock.lock();
        try {
            while (c <= 'Z') {
                while (flag) {
                    try {
                        conditiona.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if(c<='Z') System.out.print(Character.toLowerCase(c++));
                flag = true;
                conditionA.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}

//两个线程交替打印ABCD..Z字母，一个大写一个小写 目标输出：AbCdEfGhIjKlMnOpQrStUvWxYz
class Thread06PrintSynchronized{
    private Object lock = new Object();
    private char ch = 'A';
    private boolean upperCaseTurn = true;


    public void printA(){
        print(true);
    }
    public void printa(){
        print(false);
    }

    public void print(boolean isUpperCase){
        while (ch <='Z'){
            synchronized (lock){
                while(upperCaseTurn!=isUpperCase){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if(ch>'Z'){
                    lock.notify();;
                    return;
                }
                System.out.print(isUpperCase?ch++:Character.toLowerCase(ch++));
                upperCaseTurn = !upperCaseTurn;
                lock.notify();
            }
        }
    }
}

