package sf;

import binarytree.TreeNode;

public class E701 {
    //二叉搜索树的插入操作
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node==null){
           return new TreeNode(val);
        }
        if (node.val>val){
            node.left=insertIntoBST(node.left,val);
        }
        if (node.val<val){
            node.right=insertIntoBST(node.right,val);
        }
        return node;
    }
}
