package sf;

import java.util.HashMap;
import java.util.Map;

public class E146_2 {

    class LRUCache {

        static class Node {
            Node prev;
            Node next;

            int key;
            int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;

            }

        }

        static class DoubleLinkedList {

            Node head;
            Node tail;

            public DoubleLinkedList() {
                head = tail = new Node(-1, -1);
                head.next = tail;
                tail.prev = head;
            }

            public void addFirst(Node node) {
                Node next = head.next;
                node.prev = head;
                node.next = next;
                next.prev = node;
                head.next = node;
            }

            public void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = node.next;
                next.prev = prev;
            }

            public Node removeLast() {
                Node prev = tail.prev;
                remove(prev);
                return prev;
            }

        }


        private DoubleLinkedList list = new DoubleLinkedList();
        private Map<Integer,Node> map = new HashMap<>();
        private int size;

        public LRUCache(int capacity) {
            this.size = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)){
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)){
                Node node = new Node(key, value);
                map.put(key,node);
                list.addFirst(node);
                if (size<map.size()){
                    Node removed = list.removeLast();
                    map.remove(removed.key);
                }

            }else {
                Node node = map.get(key);
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            }

        }

    }




}
