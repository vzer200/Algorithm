package sf;

import binarytree.TreeNode;
import org.checkerframework.checker.units.qual.min;

public class E98 {
    public boolean isValidBST(TreeNode root) {
        //验证二叉搜索树
        //
        return reverse(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    private boolean reverse(TreeNode root, long maxValue, long minValue) {
        if (root==null){
            return true;
        }

        if (root.val>=maxValue||root.val<=minValue){
            return false;
        }


        return reverse(root.left,root.val,minValue)&&reverse(root.right,maxValue,root.val);
    }



}
