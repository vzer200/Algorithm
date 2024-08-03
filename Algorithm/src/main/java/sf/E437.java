package sf;

import binarytree.TreeNode;

public class E437 {
    private int ans;
    private int t;
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        reverse(root);
        return ans;
    }

    private void reverse(TreeNode root) {
        if (root==null){
            return;
        }
        dfs(root,root.val);
        reverse(root.left);
        reverse(root.right);
    }

    private void dfs(TreeNode root, int val) {
        if (root==null){
            return;
        }

        if (t==val){
            ans++;
        }

        if (root.left!=null)dfs(root.left, root.left.val);
        if (root.right!=null)dfs(root.right, root.right.val);
    }

}
