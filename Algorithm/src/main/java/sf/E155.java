package sf;

import java.util.LinkedList;

public class E155 {
    class MinStack {

        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        public MinStack() {
            min.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            min.push(Math.min(val,min.peek()));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
