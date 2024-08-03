package sf;

import binarytree.TreeNode;

import java.util.LinkedList;

public class E530 {
    //二叉搜素树的相邻绝对差
    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;//最近一次弹栈的元素
        int min = Integer.MAX_VALUE;
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode cur = stack.pop();
                if (pop!=null){
                    min = Math.min(cur.val- pop.val,min);
                }

                pop = cur;
                root =cur.right;

            }


        }

        return Math.abs(min);
    }

    public int getMinimumDifference2(TreeNode root){
        if (root==null){
            return 0 ;
        }
        dg(root);
        return result;
    }

    public void dg(TreeNode node) {
        if (node==null){
            return ;
        }

        dg(node.left);

        if (pre!=null){
            result = Math.min(result, pre.val-node.val);
        }
        pre = node;

        dg(node.right);

    }

}
