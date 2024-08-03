package sf;

import java.util.HashMap;
import java.util.Map;

public class E460 {
    //LFU 缓存
     static class LFUCache {
        static class Node {
            Node prev;
            Node next;
            int key;
            int value;
            int freq = 1;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public Node() {

            }

        }

        static class DoublyLinkedList {
            private Node head;
            private Node tail;
            int size;

            public DoublyLinkedList() {
                head = tail = new Node();
                head.next = tail;
                tail.prev = head;

            }

            public void addFirst(Node node) {
                //添加到头部
                Node next = head.next;
                next.prev = node;
                node.next = next;
                node.prev = head;
                head.next = node;
                size++;

            }

            public void removed(Node node) {
                //删除某个节点
                Node next = node.next;
                Node prev = node.prev;
                prev.next = next;
                next.prev = prev;
                size--;

            }

            public Node removeLast() {
                Node last = tail.prev;
                removed(last);
                return last;
            }

            public boolean isEmpty() {
                return size == 0;
            }

        }


        private HashMap<Integer, LFUCache.Node> kvmap = new HashMap<>();
        private HashMap<Integer, LFUCache.DoublyLinkedList> freqmap = new HashMap<>();
        private int capacity;
        private int MinFreq = 1;


        public void LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            //如果没找到直接return-1
            if (!kvmap.containsKey(key)) {
                return -1;
            }
            //找到进行逻辑
            LFUCache.Node node = kvmap.get(key);
            //将其转移到频率加一的链表中
            freqmap.get(node.freq).removed(node);
            if (freqmap.get(node.freq).isEmpty() && node.freq == MinFreq) {
                MinFreq++;
            }
            //频率要加1
            node.freq++;
            LFUCache.DoublyLinkedList list = freqmap.get(node.freq);
            if (list == null) {
                list = new LFUCache.DoublyLinkedList();
                freqmap.put(node.freq, list);
            }
            list.addFirst(node);
            return node.value;

        }

        public void put(int key, int value) {

            if (kvmap.containsKey(key)) {
                //如果存在进行更新
                LFUCache.Node node = kvmap.get(key);
                //将其转移到频率加一的链表中
                freqmap.get(node.freq).removed(node);
                if (freqmap.get(node.freq).isEmpty() && node.freq == MinFreq) {
                    MinFreq++;
                }
                //频率要加1
                node.freq++;
                LFUCache.DoublyLinkedList list = freqmap.get(node.freq);
                if (list == null) {
                    list = new LFUCache.DoublyLinkedList();
                    freqmap.put(node.freq, list);
                }
                list.addFirst(node);
                node.value = value;

            } else {
                //不存在进行新增逻辑
                if (kvmap.size() == capacity) {
                    LFUCache.Node node = freqmap.get(MinFreq).removeLast();
                    kvmap.remove(node.key);
                }
                LFUCache.Node node = new LFUCache.Node(key, value);
                kvmap.put(key, node);
                LFUCache.DoublyLinkedList list = freqmap.get(1);
                if (list == null) {
                    list = new LFUCache.DoublyLinkedList();
                    freqmap.put(node.freq, list);
                }
                list.addFirst(node);
                MinFreq = 1;
            }

        }
    }
}
