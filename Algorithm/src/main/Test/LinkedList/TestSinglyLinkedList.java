package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSinglyLinkedList {


    @Test
    @DisplayName("测试 addFirst")
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop1(value ->{
            System.out.println(value);
        });

        list.loop2(value ->{
            System.out.println(value);
        });

    }


    @Test
    @DisplayName("测试 addFirst")
    public void test2() {

        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        //增强for的底层就是调用了迭代器的hasNext和Next
        for (Integer value : list) {
            System.out.println(value);
        }

    }

    @Test
    @DisplayName("测试 addLast")
    public void test3() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        Assertions.assertIterableEquals(List.of(1,2,3,4),list);
    }


    @Test
    @DisplayName("测试 get")
    public void test4() {

        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        int i = list.get(3);
        System.out.println(i);

    }



    @Test
    @DisplayName("测试 insert")
    public void test5() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(0,5);
        Assertions.assertIterableEquals(List.of(5,1,2,3,4),list);
    }

    @Test
    @DisplayName("测试 removeFirst")
    public void test6() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);


        list.removeFirst();
        Assertions.assertIterableEquals(List.of(2, 3, 4), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4), list);
        list.removeFirst();
        assertIterableEquals(List.of(4), list);


    }



    @Test
    @DisplayName("测试 remove")
    public void test7() {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);

        list1.remove(2);
        assertIterableEquals(List.of(1, 2, 4), list1);


        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);

        list2.remove(0);
        assertIterableEquals(List.of(2, 3, 4), list2);

        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(4);

        assertThrows(IllegalArgumentException.class, () -> list3.remove(5));

        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.addLast(1);
        list4.addLast(2);
        list4.addLast(3);
        list4.addLast(4);

        assertThrows(IllegalArgumentException.class, () -> list4.remove(4));
    }


    private SinglyLinkedList getLinkedList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    @DisplayName("测试递归遍历")
    public void test8() {

        SinglyLinkedList linkedList = getLinkedList();
        linkedList.loop3(value->{
            System.out.println("before: "+value);
        },value->{
            System.out.println("after: "+value);
        });

    }

}