package sf;

import binarytree.TreeNode;

import java.util.LinkedList;

public class E404 {

    //左叶子之和
    public int sumOfLeftLeaves(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;
        int sum = 0;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                //如果node的左孩子不为空且为叶子节点，直接将node的左孩子记录

                if (node.left != null && node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                node = node.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    //右孩子为空
                    pop = stack.pop();
                } else if (peek.right == pop) {
                    //右孩子处理完成
                    pop = stack.pop();
                } else {
                    node = peek.right;

                }
            }
        }
        return sum;
    }

}
