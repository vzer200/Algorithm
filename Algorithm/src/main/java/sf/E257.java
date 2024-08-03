package sf;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class E257 {

    //二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> list = new LinkedList<>();
        dg(root,"->",list);
        return list;
    }

    public void dg(TreeNode node,String s ,List<String> list){
        if (node == null)
            return;

        if (node.right==null&&node.left==null){
            //如果是叶子节点的话 直接加入到list中
            list.add(s+node.val);
            return ;
        }
         dg(node.left,node.val+s,list);
         dg(node.right,node.val+s,list);
    }

}
