package LinkedList;

/**
 * 反转链表
 */
public class E01Leetcode206 {
    // 方法1
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    // 方法2
    //break结束整个循环
    //return结束方法执行
    public ListNode reverseList2(ListNode head) {
        List listNode1 = new List(head);//老链表
        List listNode2 = new List(null);//新链表
        while (true) {
            ListNode listFirst = listNode1.removeFirst();
            if (listFirst == null) {
                break;
            }
            listNode2.addFirst(listFirst);
        }
        return listNode2.head;
    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            //让first成为head
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }

    }

    // 方法3 - 递归
    public ListNode reverseList3(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode last = reverseList3(p.next);
        p.next.next = p;
        p.next = null;

        return last;
    }

    // 方法4 - 不断把 o2 头插入 n1
    public ListNode reverseList4(ListNode o1) {
        //1.空链表 2.一个元素
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;

        }
        return n1;
    }

    // 方法5 - 不断把 o1 头插到 n1
    public ListNode reverseList(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = null;

        while (o1 != null) {
            ListNode o2 = o1.next;

            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new E01Leetcode206().reverseList(o1);
        System.out.println(n1);
    }

}
