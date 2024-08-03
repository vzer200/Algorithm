package binarytree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树最大深度 - 使用后序遍历(非递归)求解
 */
public class E05Leetcode104_2 {

    /*
        思路：
        1. 使用非递归后序遍历, 栈的最大高度即为最大深度
     */
    public int maxDepth(TreeNode root) {

        TreeNode cur = root;
        TreeNode pop = null;//最近一次弹栈的元素
        int max = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    //没有右子树或者右子树处理完成
                    pop = stack.pop();
                } else {
                    //处理右子树
                    cur = peek.right;
                }

            }
        }
        return max;


    }
}
