package binarysearchtree;


/**
 * <h3>根据前序遍历构造二叉搜索树</h3>
 * 题目说明
 * <ol>
 *     <li>preorder 长度 >=1</li>
 *     <li>preorder 没有重复值</li>
 * </ol>
 */
public class E06Leetcode1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        /*TreeNode root = insert(null, preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;*/
        return Partition(preorder,0,preorder.length-1);
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val > node.val) {
         node.right = insert(node.right, val);

        }
        if (val < node.val) {
           node.left = insert(node.left, val);

        }

        return node;

    }
    public TreeNode Partition(int[] preorder, int start, int end){
        if (start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start+1;
        while(index<=end){
            if (preorder[index]>preorder[start])
            {
                break;
            }
            index++;
        }
        root.left=Partition(preorder,start+1,index-1);
        root.right=Partition(preorder,index,end);
        return root;

    }




    public static void main(String[] args) {
        /*
                8
               / \
              5   10
             / \   \
            1   7  12
         */
        TreeNode t1 = new E06Leetcode1008().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
//        TreeNode t1 = new E06Leetcode1008().bstFromPreorder(new int[]{8, 5, 7});
        TreeNode t2 = new TreeNode(8, new TreeNode(5, new TreeNode(1), new TreeNode(7)), new TreeNode(10, null, new TreeNode(12)));
        System.out.println(isSameTree(t1, t2));
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
