package LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {

    private Node head = null;


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node p = head;

            @Override
            public boolean hasNext() {//是否有下一个元素
                return p != null;
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

    static class Node {
        int value;
        Node next; //下一个指针节点

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    //添加第一个节点
    public void addFirst(int value) {
        //1.链表为空的情况
        //       head = new Node(value, null);
        //2.链表不为空的情况，将新加入的节点添加到头节点后面，并且将新节点的next指针指向第一个节点，最后将head指向新节点。
        head = new Node(value, head);

    }


    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {

            consumer.accept(p.value);
            p = p.next;

        }

    }

    public void loop2(Consumer<Integer> consumer) {

        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }

    }



    public void loop3(Consumer<Integer> before,
                      Consumer<Integer> after) {

       recursion(head,before,after);

    }

    private void recursion(Node curr, Consumer<Integer> before, Consumer<Integer> after) {
        if (curr ==null){
            return;
        }
        before.accept(curr.value);
        recursion(curr.next, before, after);
        after.accept(curr.value);
    }




    public Node findLast() {

        Node p;
        if (head == null) {//空链表
            return null;
        }

        for (p = head; p.next != null; p = p.next) {

        }


        return p;
    }


    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);

    }


    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {

            if (index == i) {
                return p;
            }

        }

        return null;
    }


    public int get(int index){
        Node node = findNode(index);
        if (node==null){
            illegalIndex(index);
        }

        return node.value;

    }

    private static void illegalIndex(int index) {
        throw new IllegalArgumentException(String.format("index[%d] 不合法 %n", index));
    }

    public void insert(int index , int value){
        Node prev = findNode(index - 1);//插入位置的上一个节点
        if (index == 0){
            addFirst(value);
            return;
        }

        if (prev == null){
            illegalIndex(index);
        }
        //将上一个节点的next指向新节点的
        prev.next = new Node(value,prev.next);//插入位置的上一个节点的next和插节点的next指向的地方相同



    }



    public void removeFirst(){
        if (head == null){
            illegalIndex(0);
        }
        head = head.next;


    }



    public void remove (int index){
        if (index == 0){
            removeFirst();
            return;
        }

        Node prev = findNode(index - 1);//找到索引位置的上一个节点，
        if (prev==null){
            illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null)
        {
            illegalIndex(index);
        }
        prev.next = removed.next;


    }



}
