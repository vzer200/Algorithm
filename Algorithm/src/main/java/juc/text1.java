package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class text1 {

    //多线程交替输出
    //关键点:整数标记 abcabcabc
    public static void main(String[] args) throws InterruptedException {
        WaitNotify waitNotify = new WaitNotify(1, 5);
        new Thread(()->{
            waitNotify.print("a",1,2);
        }).start();
        new Thread(()->{
            waitNotify.print("b",2,3);
        }).start();
        new Thread(()->{
            waitNotify.print("c",3,1);
        }).start();


       /* AwaitSignal awaitSignal = new AwaitSignal(10);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        new Thread(()->{
            awaitSignal.print("a",a,b);
        }).start();
        new Thread(()->{
            awaitSignal.print("b",b,c);
        }).start();
        new Thread(()->{
            awaitSignal.print("c",c,a);
        }).start();
        //需要主线程唤醒

        Thread.sleep(1000);
        awaitSignal.lock();
        try {
            a.signal();
        }finally {
            awaitSignal.unlock();
        }*/

    }


}


//方法一 synchronized
class WaitNotify{

    //等待标记
    private int flag;

    //循环次数
    private final int loopNumber;

    //打印方法
    public void print(String str, int waitFlag,int nextFlag){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while (waitFlag!=flag){
                    //表示不同 需要等待
                    try {
                        this.wait(); //用锁对象调用wait等待
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }

    }

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }
}


//方法二 用ReentrantLock
class AwaitSignal extends ReentrantLock{
    //ReentrantLock的优点在于可重入，能设置多个条件变量
    private final int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String str, Condition current,Condition next){

        for (int i = 0; i < loopNumber; i++) {
            lock();
            try {
                try {
                    current.await();
                    System.out.print(str);
                    //唤醒下个休息室
                    next.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }finally {
                unlock();
            }

        }
    }


}