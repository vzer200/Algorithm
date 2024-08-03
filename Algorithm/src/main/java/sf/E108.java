package sf;

import binarytree.TreeNode;

import java.util.Arrays;

public class E108 {
    //将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST2(int[] nums) {

        //给一个升序数组，将其转化为平衡的二叉搜索树
        int index = nums.length/2;
        TreeNode root = new TreeNode(nums[index]);
        for (int i = 0; i < nums.length; i++) {
            if (i==index){

                int[] left = Arrays.copyOfRange(nums, 0, index);
                int[] right = Arrays.copyOfRange(nums, index+1, nums.length);
                root.left = sortedArrayToBST2(left);
                root.right = sortedArrayToBST2(right);
                break;
            }

        }
        return root;
    }

    public TreeNode helper(int[] nums, int left, int right) {
         int index = (left+right)/2;
        TreeNode root = new TreeNode(nums[index]);
        if (left>right){
            return null;
        }
        root.left=helper(nums,left,index-1);
        root.right=helper(nums,index+1,right);
        return root;

    }






}
