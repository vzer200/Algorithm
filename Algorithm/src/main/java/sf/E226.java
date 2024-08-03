package sf;


import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class E226 {
    //反转二叉树

    public TreeNode invertTree_1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }


    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return null;
        }
       //广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            poll.left = poll.right;
            poll.right = left;
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }

        return root;
    }

}
