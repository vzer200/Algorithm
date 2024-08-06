package myThread;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



//手撕线程池
public class ThreadPoll{

    private BlockingQueue<Runnable> taskQueue;
    private Set<Worker> workers = ConcurrentHashMap.newKeySet();
    private int coreSize;
    private long timeout;
    private TimeUnit timeUnit;

    public ThreadPoll(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
    }

    class Worker extends Thread{
        private Runnable task;
        public Worker(Runnable task){
            this.task = task;
        }

        @Override
        public void run() {
            while(task!=null ||(task =taskQueue.take())!=null){
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    task=null;
                }
            }
            synchronized (workers){
                workers.remove(this);
            }
        }
    }

}



/*
class BlockingQueue<T>{

    //手撕阻塞队列
    private Deque<T> queue = new ArrayDeque<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition fullWait = lock.newCondition();
    private Condition emptyWait = lock.newCondition();

    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    //阻塞获取
    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    emptyWait.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            T head = queue.removeFirst();
            fullWait.signal();
            return head;
        } finally {
            lock.unlock();
        }
    }

    //阻塞
    public void put(T element){
        lock.lock();
        try{
            while(queue.size()==capacity){
                try {
                    fullWait.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.addLast(element);
            emptyWait.signal();
        }finally {
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try {
            return queue.size();
        }finally {
            lock.unlock();
        }
    }


    public int getCapacity() {
        return capacity;
    }
}

*/

class BlockingQueue<T>{
    private Deque<T> queue = new ArrayDeque<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition fullWait = lock.newCondition();
    private Condition emptyWait = lock.newCondition();
    private int capacity;

    public BlockingQueue(int capacity){
        this.capacity = capacity;
    }

    public T take(){
        lock.lock();
        try {
            while(queue.isEmpty()){
                try {
                    emptyWait.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            T head = queue.removeFirst();
            fullWait.signal();
            return head;
        }finally {
            lock.unlock();
        }
    }
    public void put(T element){
        lock.lock();
        try{
            while(queue.size()==capacity){
                try {
                    fullWait.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.addLast(element);
            emptyWait.signal();
        }  finally {
            lock.unlock();
        }
    }

    public int getCapacity() {
        return capacity;
    }
}