package sf;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E114 {
    public void flatten(TreeNode root) {

        while (root != null) {
            TreeNode left = root.left;
            if (left == null) {
                root = root.right;
            } else {
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }


    }


}
