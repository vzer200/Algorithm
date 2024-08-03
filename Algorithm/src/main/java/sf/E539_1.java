package sf;

import binarytree.TreeNode;

import java.util.LinkedList;

public class E539_1 {
    //把二叉搜索树转换为累加树
    public TreeNode convertBST(TreeNode root) {
        if (root==null){
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur  = root;
        TreeNode pre  = null;//上一个节点
        while(cur!=null||!stack.isEmpty()){
            if (cur!=null){
             stack.push(cur);
             cur = cur.right;
            }else {
                TreeNode pop = stack.pop();
                if (pre!=null){
                    pop.val = pre.val+pop.val;
                }
                pre = pop;
                cur = pop.left;

            }
        }
        return root;
    }
}
