package sf;

import java.util.HashSet;
import java.util.Set;

public class E202 {
    public boolean isHappy(int n) {
       int slow = n;
       int fast = getNext(n);
       while (slow!=fast){
           slow = getNext(slow);
           fast = getNext(getNext(fast));
       }
       return slow==1;
    }

    public int getNext(int x) {

        int a = 0;
        int total = 0;
        while (x > 0) {
            a = x % 10;
            x = x / 10;
            total += a * a;

        }

        return total;
    }
}
