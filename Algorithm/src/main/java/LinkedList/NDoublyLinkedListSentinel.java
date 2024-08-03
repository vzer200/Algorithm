package LinkedList;

import java.util.Iterator;

public class NDoublyLinkedListSentinel implements Iterable<Integer> {

    //双向环形链表 带哨兵
    private Node Sentinel = new Node(null, null, -1);

    public NDoublyLinkedListSentinel() {
        Sentinel.prev = Sentinel;
        Sentinel.next = Sentinel;
    }

    private static class Node {
        Node prev;
        Node next;
        int value;

        public Node(Node prev, Node next, int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }


    public void addFirst(int value) {
        Node a = Sentinel;
        Node b = Sentinel.next;
        Node added = new Node(a, b, value);
        a.next = added;
        b.prev = added;

    }


    public void addLast(int value) {

        Node a = Sentinel;
        Node b = Sentinel.prev;//最后那个节点
        Node Lasted = new Node(b, a, value);
        a.prev = Lasted;
        b.next = Lasted;

    }


    public void removeFirst() {
        Node a = Sentinel;
        Node removed = Sentinel.next;
        if (removed == Sentinel) {
            throw new IllegalArgumentException("非法的");
        }
        Node b = removed.next;
        a.next = b;
        b.prev = a;

    }


    public void removeLast() {

        Node a = Sentinel;
        Node removed = Sentinel.prev;
        if (removed == Sentinel) {
            throw new IllegalArgumentException("非法的");
        }
        Node b = removed.prev;
        a.prev = b;
        b.next = a;

    }


    public void removeByValue(int value) {
        Node node = findByValue(value);
        if (node == null) {
            System.out.println("寄");
        }
        Node a = node.prev;
        Node b = node.next;
        a.next = b;
        b.prev = a;
    }


    public Node findByValue(int value) {
        Node p = Sentinel.next;
        while (p != Sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }


    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            Node p = Sentinel.next;

            @Override
            public boolean hasNext() {
                return p != Sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
