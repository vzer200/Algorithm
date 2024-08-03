package sf;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E222 {
    //完全二叉树的节点个数
    //常规遍历
    public int countNodes(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop =null;
        List<Integer> result = new ArrayList<>();
       while(node!=null||!stack.isEmpty()){
           if (node!=null) {
               stack.push(node);
               result.add(node.val);
               node = node.left;
           }else {
               TreeNode peek = stack.peek();
               if (peek.right==null||peek.right==pop){
                   //没有右子树或者是处理完右子树
                   pop = stack.pop();
               }else {
                   node = peek.right;
               }
           }

       }
        return result.size();
    }
}
