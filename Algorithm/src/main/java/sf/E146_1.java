package sf;

import LinkedList.ListNode;

import java.util.HashMap;
public class E146_1 {

    public class LRUCache {

        private final HashMap<Integer, Node> map = new HashMap<>();
        private final DoublyLinkedList list = new DoublyLinkedList();
        private int capacity;

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


        static class DoublyLinkedList {
            private Node head;
            private Node tail;

            public DoublyLinkedList() {
                head = tail = new Node(-1,-1);
                head.next = tail;
                tail.prev = head;

            }

            public void remove(Node n) {
                Node next = n.next;
                Node prev = n.prev;
                prev.next = next;
                next.prev = prev;

            }

            public void addFirst(Node n) {
                Node next = head.next;
                next.prev = n;
                n.next = next;
                n.prev = head;
                head.next = n;
            }

            public Node removeLast() {
                Node last = tail.prev;
                remove(last);
                return last;
            }

        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key){
            if (!map.containsKey(key)){
                return-1;
            }
            Node node = map.get(key);
            //lru算法移除最久未使用
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key,int value){
            if (!map.containsKey(key)){
                Node node = new Node(key,value);
                map.put(key,node);
                list.addFirst(node);
                if (capacity< map.size()){
                    Node removed = list.removeLast();
                    map.remove(removed.key);
                }
            }else {
                Node node = map.get(key);
                node.value = value;
                map.remove(key,node);
                map.put(key,node);
                list.remove(node);
                list.addFirst(node);
            }
        }


    }
}