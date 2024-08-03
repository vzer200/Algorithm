package sf;

import binarytree.TreeNode;

public class E104_1 {
    //二叉树的最大深度
    //利用递归来解决
    public int maxDepth2(TreeNode node) {

        if (node==null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return  Math.max(left, right)+1;
    }

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
