package sf;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E539 {

    int sum ;
    //把二叉搜索树转换为累加树
    public TreeNode convertBST(TreeNode root) {
       sum = 0;
       dg(root);
       return root;
    }

    public void dg(TreeNode node){
        if (node==null){
            return;
        }
        dg(node.right);
        //处理值

        sum = sum+ node.val;
        node.val = sum;
        dg(node.left);

    }

}
