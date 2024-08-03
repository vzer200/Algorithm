package blockingqueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单锁实现
 *
 * @param <E> 元素类型
 */
@SuppressWarnings("all")
public class BlockingQueue1<E> implements BlockingQueue<E> {


    private final E[] array;
    private int size;
    private int head;
    private int tail;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition headWaits = reentrantLock.newCondition();
    private Condition tailWaits = reentrantLock.newCondition();

    public BlockingQueue1(int cap) {
        array = (E[]) new Object[cap];
    }

    public boolean isfull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        reentrantLock.lockInterruptibly();
        try {
            while (isfull()) {
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();

        } finally {
            reentrantLock.unlock();
        }
    }


    //添加等待时间上限
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {

        reentrantLock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            E e = array[head];
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;

        } finally {
            reentrantLock.unlock();
        }


    }


}