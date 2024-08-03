package sf;

import binarytree.TreeNode;

public class E654 {
    //最大二叉树
    //递归分治
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length - 1);

    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int idx = left;
        for (int i = idx; i < right; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        TreeNode ans = new TreeNode(nums[idx]);
        ans.left = build(nums, left, idx - 1);
        ans.right = build(nums, idx + 1, right);
        return ans;
    }

}
