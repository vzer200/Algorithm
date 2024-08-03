package sf;

import java.util.HashMap;

public class E146 {
    //LRU缓存

    //双向链表
    static class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }

    }
    static class DoublyLinkedList{
        private Node head;
        private Node tail;

        public DoublyLinkedList() {
            head =tail = new Node();
           head.next = tail;
           tail.prev = head;

        }

        public void addFirst(Node node){
            //添加到头部
            Node next = head.next;
            next.prev = node;
            node.next = next;
            node.prev = head;
            head.next = node;

        }
        public void removed(Node node){
            //删除某个节点
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;

        }
        public Node removeLast(){
            Node last = tail.prev;
            removed(last);
            return last;
        }

    }

    private final HashMap<Integer,Node> map = new HashMap<>();
    private final DoublyLinkedList list = new DoublyLinkedList();
    private int capacity;

    public void LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            //没找到
            return -1;
        }
        Node node = map.get(key);
        list.removed(node);
        list.addFirst(node);
        return node.value;

    }

    public void put(int key, int value) {

        if (!map.containsKey(key)){
            //不存在走添加逻辑
            Node node = new Node(key, value);
            map.put(key,node);
            list.addFirst(node);
            if (map.size()>capacity){
                Node removed = list.removeLast();
                //map中也要删除
                map.remove(removed.key);
            }
        }else {
            //存在走更新逻辑
            Node node = map.get(key);
            node.value = value;
            list.removed(node);
            list.addFirst(node);
        }

    }

}
