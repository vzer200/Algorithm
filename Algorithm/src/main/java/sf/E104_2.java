package sf;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大深度 - 使用层序遍历
 */
public class E104_2 {

    /*
        思路：
        1. 使用层序遍历, 层数即最大深度
     */

    public int maxDepth(TreeNode root) {
        //广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(root);
        if (!queue.isEmpty()){
            int size = queue.size();
            //最大深度，把每一层的都加入到队列然后弹出来
            while (size>0){
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

















    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth =0 ;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);

                }
                if (poll.right != null) {
                    queue.offer(poll.right);

                }
            }
            depth++;
        }
        return depth;
    }


}
