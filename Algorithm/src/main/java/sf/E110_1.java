package sf;

import binarytree.TreeNode;

public class E110_1 {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return dg(root) != -1;
    }

    public int dg(TreeNode node){
        if (node==null){
            return 0;
        }
        int left = dg(node.left);
        int right = dg(node.right);
        if (left==-1){
            return -1;
        }
        if (right==-1){
            return -1;
        }

        return Math.abs(left-right)<2? Math.max(left,right)+1:-1;
    }
}
