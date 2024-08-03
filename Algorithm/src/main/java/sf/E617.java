package sf;

import binarytree.TreeNode;

public class E617 {
    //合并二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dg(root1,root2);
    }

    public TreeNode dg(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 ==null ? root2: root1;
        }

        root1.val = root1.val + root2.val;
        root1.left=dg(root1.left, root2.left);//向左递归
        root1.right=dg(root1.right, root2.right);//向左递归

        return root1;
    }


}
