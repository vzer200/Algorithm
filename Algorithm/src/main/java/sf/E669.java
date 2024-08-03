package sf;

import binarytree.TreeNode;

public class E669 {
    //修剪二叉树
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val<low){
            //当前节点小于最小值,那么当前节点的左子树肯定也小于最小值，直接向右递归
            return trimBST(root.right,low,high);

        } else if (root.val > high) {
            return trimBST(root.left,low,high);
        }else {
            //现在root的值肯定是位于最小值与最大值中间
            root.left=trimBST(root.left,low,high);
            root.right=trimBST(root.right,low,high);
        }
        return root;
    }
}
