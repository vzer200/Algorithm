package myThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

//仿购票系统，目前有1000张票，同时有10个购票窗口，模拟购票流程，打印购票结果，比如：从1窗口购买1张票，剩余999张票
public class Thread10 {

    public static void main(String[] args) {
        TicketManager ticketManager = new TicketManager(1000); // 初始化 1000 张票

        for (int i = 0; i < 10; i++) {
            int windowNumber = i;
            new Thread(() -> ticketManager.buyTicket(windowNumber), "窗口" + windowNumber).start();
        }
    }
}

class TicketManager {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int remainingTickets;

    public TicketManager(int initialTickets) {
        this.remainingTickets = initialTickets;
    }

    public void buyTicket(int windowNumber) {
        while (true) {
            lock.lock();
            try {
                if (remainingTickets <= 0) {
                    break; // 如果票已售罄，退出循环
                }

                // 模拟购票流程
                int number = new Random().nextInt(10) + 1; // 确保至少购买1张票
                if (remainingTickets >= number) {
                    remainingTickets -= number;
                    System.out.println("从窗口 G" + windowNumber + " 购买了 " + number + " 张票, 还剩 " + remainingTickets + " 张票");
                }

                // 唤醒其他线程
                condition.signalAll();

                // 模拟每个窗口之间的购票时间间隔
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            } finally {
                lock.unlock();
            }
        }
    }
}

class TicketSystemDemo {
    /**
     * 总共票数
     */
    private static final int TOTAL_TICKETS = 1000;
    /**
     * 剩余票数
     */
    private static int remainingTICKETS = TOTAL_TICKETS;
    /**
     * 锁对象,用于同步
     */
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // 创建线程，并且启动
        for (int i = 0; i < 10; i++) {
            new Thread(new TicketSeller(i)).start();
        }

    }

    private static class TicketSeller implements Runnable {
        private int windowNumber;

        public TicketSeller(int windowNumber) {
            this.windowNumber = windowNumber;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (remainingTICKETS > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        buyTicket();
                    } else {
                        break;
                    }
                    // 模拟购票后的其他操作，增加随机性
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }


        private void buyTicket() {
            int number = new Random().nextInt(10);
            if(remainingTICKETS   >= number && number > 0){
                remainingTICKETS = remainingTICKETS - number;
                System.out.println("从窗口 G1000" + windowNumber + " 购买了 " + number + " 张票, 还剩 " + remainingTICKETS + " 张票");
            }
        }
    }
}
