package sf;

import java.util.Random;

public class E1206 {

    static Random r = new Random();

    static int randomLevel(int max) {
        int x = 1;
        while (x < max) {
            if (r.nextBoolean()) {
                return x;
            }
            x++;
        }
        return x;
    }

    public static class Skiplist {

        private static final int Max = 10;
        Node head = new Node(-1);

        static class Node {
            Node[] next = new Node[Max];
            int val;


            public Node(int val) {
                this.val = val;
            }
        }

        public Node[] find(int val) {
            Node[] path = new Node[Max];
            Node curr = head;
            for (int level = Max - 1; level >= 0; level--) { // 从上向下找
                while (curr.next[level] != null && curr.next[level].val < val) { // 向右找
                    curr = curr.next[level];
                }
                path[level] = curr;
            }
//            System.out.println(curr);
            return path;
        }

        public boolean search(int target) {
            Node[] path = find(target);
            Node node = path[0].next[0];
            return node!=null&&node.val==target;
        }

        public void add(int num) {
            Node[] path = find(num);
            Node node = new Node(num);
            int level = randomLevel(Max);
            for (int i = 0; i <level; i++) {
                node.next[i] = path[i].next[i];
                path[i].next[i] = node;
            }
        }

        public boolean erase(int num) {
            Node[] path = find(num);
            Node node = path[0].next[0];
            if (node==null||node.val!=num){
                return false;
            }
            for (int i = 0; i < Max; i++) {
                if (path[i].next[i]!=node){
                    break;
                }
                path[i].next[i] = node.next[i];
            }
            return true;
        }


    }

}
