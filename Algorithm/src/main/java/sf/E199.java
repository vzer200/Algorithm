package sf;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E199 {

    private List<Integer> res = new ArrayList<>();
    //二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        reverse(root,0);
        return res;
    }

    private void reverse(TreeNode root, int depth) {
        if (root==null){
            return;
        }

        if (depth==res.size()){
            res.add(root.val);
        }
        reverse(root.right,depth+1);
        reverse(root.left,depth+1);
    }

}
