package My;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {

    static class Node {


        int Freq;//频率
        Character ch;//字符
        String code;//编码
        Node left;
        Node right;

        public Node() {
        }

        public Node(Character ch) {
            this.ch = ch;
        }

        public Node(int freq, Node left, Node right) {
            this.Freq = freq;
            this.right = right;
            this.left = left;
        }

        /**
         * 获取
         *
         * @return Freq
         */
        public int getFreq() {
            return Freq;
        }

        public boolean isLeaf() {
            return left == null;
        }

        public String toString() {
            return "node{Freq = " + Freq + ", ch = " + ch + "}";
        }
    }


    Map<Character, Node> map = new HashMap<>();
    String str;
    Node root;

    public HuffmanTree(String str) {
        this.str = str;
        //统计频次
        char[] array = str.toCharArray();
        for (char c : array) {
            if (!map.containsKey(c)) {
                map.put(c, new Node(c));
            }
            Node node = map.get(c);
            node.Freq++;
        }


        //构建树
        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(Node::getFreq)
        );
        queue.addAll(map.values());
        while (queue.size() >= 2) {
            Node x = queue.poll();
            Node y = queue.poll();
            int freq = x.Freq + y.Freq;
            queue.add(new Node(freq, x, y));
        }
        root = queue.poll();
        //计算每个字符的编码
        int sum = dfs(root, new StringBuilder());
        for (Node value : map.values()) {
            System.out.println(value + " " + value.code);
        }
        System.out.println(sum);
    }

    private int dfs(Node node, StringBuilder code) {
        int sum = 0;
        if (node.isLeaf()) {
            node.code = code.toString();
            sum = code.length() * node.Freq;
        } else {
            sum += dfs(node.left, code.append("0"));
            sum += dfs(node.right, code.append("1"));
        }
        if (code.length() > 0) {
            code.deleteCharAt(code.length() - 1);
        }

        return sum;
    }

    //编码
    public String encode() {
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(map.get(c).code);
        }
        return sb.toString();
    }

    //解码
    public String decode(String str) {//0001011111111
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Node node = root;
        int index = 0;
        while (index < array.length) {
            if (!node.isLeaf()) {
                //node如果不是叶子节点
                if (array[index] == '0') {
                    node = node.left;
                } else if (array[index] == '1') {
                    node = node.right;
                }
                index++;
            }
            if (node.isLeaf()){
                //node是叶子节点
                sb.append(node.ch);
                node = root;
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        HuffmanTree s = new HuffmanTree("abbccccccc");
        String encode = s.encode();
        // System.out.println(encode);
        String a = s.decode(encode);
        System.out.println(a);
    }

}
