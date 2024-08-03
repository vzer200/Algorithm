package sf;

import binarytree.TreeNode;

import java.util.Arrays;

public class E105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                //找到中序遍历的根
                int[] left = Arrays.copyOfRange(inorder, 0, i);
                int[] right = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] leftPre = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] rightPre = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                root.left = buildTree(leftPre, left);
                root.right = buildTree(rightPre, right);
                break;
            }
        }
        return root;
    }
}
