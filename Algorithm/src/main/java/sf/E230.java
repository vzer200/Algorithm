package sf;

import binarytree.TreeNode;

import java.util.*;

public class E230 {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            curr = curr.right;
        }
        return curr.val;
    }


    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }


}
