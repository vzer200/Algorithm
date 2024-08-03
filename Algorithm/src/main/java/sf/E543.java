package sf;

import binarytree.TreeNode;

public class E543 {
    private  int ans ;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1;
    }

    public int depth(TreeNode root){
        if (root==null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right + 1);//ans和当前子树所经历节点数的最大值比较
        return Math.max(left,right)+1;

    }
}
