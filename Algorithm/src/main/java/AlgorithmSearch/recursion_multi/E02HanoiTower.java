package AlgorithmSearch.recursion_multi;

import org.springframework.util.StopWatch;

import java.util.LinkedList;

/**
 * 递归汉诺塔
 */
public class E02HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();


    public static void init(int n){
        for (int i = n; i >=1; i--) {
            a.addLast(i);
        }
    }

    /**
     * <h3>移动圆盘</h3>
     *
     * @param n 圆盘个数
     * @param a 由
     * @param b 借
     * @param c 至
     */

    static void move(int n ,LinkedList<Integer> a,
                     LinkedList<Integer> b,LinkedList<Integer> c){

        if (n==0){
            return;
        }

         move(n-1,a,c,b);
        c.addLast(a.removeLast());
        print();
        move(n-1,b,a,c);
    }


    public static void main(String[] args) {
        init(64);
        print();
       move(64,a,b,c);
    }

    private static void print() {
        System.out.println("-------------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }


}
