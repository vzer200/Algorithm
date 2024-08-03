package sf;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class E111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (poll.left == null && poll.right == null) {
                    return ans;
                }

            }
        }


        return ans;

    }
}
