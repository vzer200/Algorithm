package sf;

import binarytree.TreeNode;

import java.util.Arrays;

public class E106 {
    //从中序与后序遍历序列构造二叉树
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0) {
            return null;
        }

        int rootValue = postOrder[postOrder.length-1];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inOrder.length; i++) {

            if (rootValue==inOrder[i]){
                //找到关键点
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);//左子树
                int[] inRight = Arrays.copyOfRange(inOrder, i+1, inOrder.length);//右子树

                int[] poLeft = Arrays.copyOfRange(postOrder, 0, i);
                int[] poRight = Arrays.copyOfRange(postOrder, i, postOrder.length-1);

                root.left = buildTree(inLeft,poLeft);
                root.right = buildTree(inRight,poRight);

                break;
            }

        }
        return root;
    }
}
