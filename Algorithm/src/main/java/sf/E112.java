package sf;

import binarytree.TreeNode;

public class E112 {
    //路径总和
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        targetSum-= root.val;
        if (root.left==null&&root.right==null){
            return targetSum==0;
        }
        boolean left = hasPathSum(root.left, targetSum);
        if (left){
            return true;
        }
        boolean right = hasPathSum(root.right, targetSum);
        if (right){
            return true;
        }
        return false;

    }
}
