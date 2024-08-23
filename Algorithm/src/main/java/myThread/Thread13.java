package myThread;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

//手动实现cas
public class Thread13 {
    // 锁的状态 0 表示未占用, 1 表示已占用
    private volatile int state = 0;

    // 用于模拟 CAS 操作的 AtomicReference
    private AtomicReference<Thread> owner = new AtomicReference<>(null);

    // 等待队列，使用 LinkedList 实现 FIFO
    private Queue<Thread> waitQueue = new LinkedList<>();

    // CAS 操作的实现
    private boolean compareAndSwap(int expected, int newValue) {
        if (state == expected) {
            state = newValue;
            return true;
        }
        return false;
    }

    // 加锁方法
    public void lock() {
        Thread currentThread = Thread.currentThread();
        boolean acquired = false;

        synchronized (this) {
            // 将当前线程加入等待队列
            waitQueue.offer(currentThread);

            // 尝试获取锁，如果锁未被占用且队列头是当前线程，执行 CAS 操作
            while (!acquired) {
                if (waitQueue.peek() == currentThread && compareAndSwap(0, 1)) {
                    owner.set(currentThread);  // 设置当前线程为锁的持有者
                    acquired = true;  // 成功获取锁
                    waitQueue.poll();  // 获取锁后移出队列头
                } else {
                    // 如果无法获取锁，阻塞等待唤醒
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    // 解锁方法
    public void unlock() {
        Thread currentThread = Thread.currentThread();

        synchronized (this) {
            // 只有锁的持有者才能解锁
            if (owner.get() == currentThread) {
                state = 0;  // 释放锁
                owner.set(null);

                // 唤醒等待队列中的下一个线程
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread13 lock = new Thread13();

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " trying to acquire lock");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock");
                // 模拟处理一些工作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " releasing lock");
                lock.unlock();
            }
        };

        // 启动多个线程来测试公平锁
        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }
}
