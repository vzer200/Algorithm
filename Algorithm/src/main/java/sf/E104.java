package sf;

import binarytree.TreeNode;
import stack.ArrayStack;
import stack.Stack;

import java.util.LinkedList;

public class E104 {

    //二叉树的最大深度
    //后续遍历，栈的大小等于最大深度
    public int maxDepth(TreeNode node) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        int max =0;

        TreeNode pop = null;

        while(node!=null||!stack.isEmpty()){
            if (node!=null) {
                stack.push(node);
                node = node.left;
                if (max<stack.size()){
                    max = stack.size();
                }
            }else {
                TreeNode peek = stack.peek();
                if (peek.right==pop||peek.right ==null){
                    //没有右子树或者已经遍历完右子树
                     pop = stack.pop();
                }else {
                    node = peek.right;
                }

            }
        }
        return max;
    }

}
