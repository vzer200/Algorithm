package sf;

import binarytree.TreeNode;

public class E101 {

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }

    public boolean check(TreeNode left,TreeNode right) {
        if (left == null && right ==null){
            return true;
        }
        if (left==null){
            return false;
        }
        if (right==null){
            return false;
        }

        boolean l = check(left.left, right.right);
        boolean r = check(left.right, right.left);
        return l&&r;
    }

}
