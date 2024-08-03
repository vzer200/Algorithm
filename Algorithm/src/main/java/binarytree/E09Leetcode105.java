package binarytree;


import java.util.Arrays;

/**
 * 根据前序中序遍历结果构造二叉树
 */
public class E09Leetcode105 {

    /*
        preOrder = {1,2,4,3,6,7}
        inOrder = {4,2,1,6,3,7}

        根 1
            pre         in
        左  2,4         4,2
        右  3,6,7       6,3,7


        根 2
        左 4

        根 3
        左 6
        右 7
     */

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length==0){
            return null;
        }


        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i]==rootValue){

                int[] Inleft = Arrays.copyOfRange(inOrder, 0,i);
                int[] Inright = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                int[] preleft = Arrays.copyOfRange(preOrder, 1,i+1);
                int[] preright = Arrays.copyOfRange(preOrder, i+1,preOrder.length);

                root.left= buildTree(preleft, Inleft);
                root.right= buildTree(preright, Inright);
                break;

            }


        }

        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 3, 6, 7};
        int[] inOrder = {4, 2, 1, 6, 3, 7};
        TreeNode root = new E09Leetcode105().buildTree(preOrder, inOrder);
    }

}
