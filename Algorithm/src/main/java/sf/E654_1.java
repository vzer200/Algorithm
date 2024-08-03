package sf;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class E654_1 {
    //单调栈最优解
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while(!deque.isEmpty()){
                TreeNode topNode = deque.peekLast();
                if (topNode.val> node.val){
                    //栈顶元素大于要入栈的元素
                    deque.addLast(node);
                    topNode.right = node;
                    break;
                }else {
                    deque.removeLast();
                    node.left = topNode;
                }

            }
            if (deque.isEmpty()) deque.addLast(node);
        }
        return deque.peek();
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        Deque<TreeNode> deque = new ArrayDeque();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while(!deque.isEmpty()) {
                TreeNode topNode = deque.peekLast();
                if (topNode.val > node.val) {
                    deque.addLast(node);
                    topNode.right = node;
                    break;
                } else {
                    deque.removeLast(); // 出栈操作
                    node.left = topNode;
                }
            }
            if (deque.isEmpty()) deque.addLast(node);
        }
        return deque.peek();
    }


}
