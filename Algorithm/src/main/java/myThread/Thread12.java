package myThread;


//问题描述：写两个线程打印 1-100，⼀个线程打印奇数，⼀个线程打印偶数。
public class Thread12 {

}

class ParityPrinter {
    private int max = 0;
    private final Object lock = new Object();
    private int count = 1;

    public ParityPrinter(int max) {
        this.max = max;
    }

    public void print() {

    }

}


//不能确保odd线程一定打印奇数，
class PrintNumbersSync {
    private final Object lock = new Object();
    private int number = 1;
    private int MAX = 0;

    public PrintNumbersSync(int MAX) {
        this.MAX = MAX;
    }

    public void printNumbers() {
        while (number <= MAX) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ": " + number++);
                lock.notify();
                if (number <= MAX) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintNumbersSync printer = new PrintNumbersSync(100);
        Thread t1 = new Thread(printer::printNumbers, "Odd");
        Thread t2 = new Thread(printer::printNumbers, "Even");

        t1.start();
        t2.start();
    }
}

class ParityPrinter2 {
    private final int max;
    private int count = 1;
    private final Object lock = new Object();

    public ParityPrinter2(int max) {
        this.max = max;
    }

    public void printOdd() {
        print(true);
    }

    public void printEven() {
        print(false);
    }

    private void print(boolean isOdd) {
        while (count <= max) {
            synchronized (lock) {
                // 确保当前线程只能在正确的轮次打印
                while (isOdd == (count % 2 == 0) && count <= max) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (count <= max) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        ParityPrinter2 printer = new ParityPrinter2(100);
        // 创建打印奇数和偶数的线程

        Thread t1 = new Thread(() -> {
            printer.printOdd();
        }, "Odd");
        Thread t2 = new Thread(printer::printEven, "Even");
        t1.start();
        t2.start();
    }
}


class ParityPrinter3 {
    private final int max;
    private int count = 1;

    private final Object lock = new Object();

    public ParityPrinter3(int max) {
        this.max = max;
    }

    public void printOdd() {
        print(true);
    }

    public void printEven() {
        print(false);
    }

    public void print(boolean flag) {
        while (count <= max) {
            synchronized (lock) {
                while (flag == (count % 2 == 0) && count <= max) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (count <= max) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    lock.notify();
                }

            }
        }
    }

    public static void main(String[] args) {
        ParityPrinter3 parityPrinter3 = new ParityPrinter3(10);
        Thread t1 = new Thread(() -> {
            parityPrinter3.printEven();
        }, "Even");
        Thread t2 = new Thread(() -> {
            parityPrinter3.printOdd();
        }, "Odd");
        t1.start();
        t2.start();
    }

}
