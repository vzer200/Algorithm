package sf;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E94 {
    public List<Integer> inorderTraversal2(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr!=null||!stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr =curr.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            curr = pop.right;

        }

        ArrayList<Integer> res = new ArrayList<>();
        reverse2(res,root);
        return res;
    }

    private void reverse2(ArrayList<Integer> res, TreeNode root) {
        if (root==null){
            return;
        }

        reverse2(res,root.left);
        res.add(root.val);
        reverse2(res,root.right);

    }



    public List<Integer> inorderTraversal(TreeNode root) {


        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr!=null||!stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            //
            TreeNode pop = stack.pop();
            result.add(pop.val);
            curr = pop.right;

        }
        return result;
    }

    public void reverse(ArrayList<Integer> res,TreeNode root){
        if (root==null){
            return;
        }

        reverse(res,root.left);
        res.add(root.val);
        reverse(res ,root.right);
    }
}
