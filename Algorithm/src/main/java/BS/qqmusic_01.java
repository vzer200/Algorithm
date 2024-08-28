package BS;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class qqmusic_01 {
    public int minMergeSteps(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }

        int mergeCount = 0;
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            if (current.val == 0) {
                // 当前节点为0，检查前一个节点
                if (prev != null && prev.val == 0) {
                    mergeCount++;
                }
            } else {
                // 当前节点不为0，检查前一个节点
                if (prev != null && prev.val != 0) {
                    mergeCount++;
                }
            }

            prev = current;
            current = current.next;
        }

        return mergeCount;
    }

    // 测试用例
    public static void main(String[] args) {
        // 示例链表: 0 -> 1 -> 0
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;

        qqmusic_01 solution = new qqmusic_01();
        int result = solution.minMergeSteps(node1);
        System.out.println(result);  // 输出0
    }
}
