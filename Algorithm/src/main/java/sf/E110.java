package sf;

import binarytree.TreeNode;

public class E110 {
    //平衡二叉树

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(dg(root.left) - dg(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int dg(TreeNode node){
        if (node==null){
            return 0;
        }

        return Math.max(dg(node.left),dg(node.right))+1;
    }


}
