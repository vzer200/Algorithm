package LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedListSentinel implements Iterable<Integer> {

    //带哨兵的双向链表
    //加哨兵的目的，防止空链表的发生


    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel() {
        head = new Node(null, null, 888);
        tail = new Node(null, null, 666);
        head.next = tail;
        tail.prev = head;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node p = head.next;

            @Override
            public boolean hasNext() {//是否有下一个元素
                return p != tail;
            }

            @Override
            public Integer next() {//返回当前值，并指向下一个元素
                int value = p.value;
                p = p.next;
                return value;
            }
        };

    }


    //当某一个内部类使用了外部类的一个成员变量时，就不允许加static修饰；
    //当内部类是相对独立时，跟外部类的成员变量没有任何关系，就可以加static修饰；

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


    //添加第一个节点
    public void addFirst(int value) {
        insert(0, value);
    }




    public void addLast(int value) {
        Node last = tail.prev;//尾哨兵的前一个节点
        Node added = new Node(last, tail, value);
//          last = added.prev;
//          tail = added.next;
        last.next = added;
        tail.prev = added;

    }


    private Node findNode(int index) {

        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (index == i) {
                return p;
            }
        }
        return null;
    }




    public void insert(int index, int value) {

        Node prev = findNode(index - 1);//插入后的上一个节点
        if (prev == null) {
            illegalIndex(index);
        }
        Node next = prev.next;//插入后的下一个节点
        Node inserted = new Node(prev, next, value);
        prev.next = inserted;
        next.prev = inserted;
        /*prev.next = new Node(prev, next, value);
        next.prev = prev.next;*/


    }


    public void removeFirst() {
        remove(0);
    }


    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == tail) {
            illegalIndex(index);
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;

    }


    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;

    }


    private static void illegalIndex(int index) {
        throw new IllegalArgumentException(String.format("index[%d] 不合法 %n", index));
    }


}



