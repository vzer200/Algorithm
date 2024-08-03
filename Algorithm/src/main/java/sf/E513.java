package sf;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class E513 {
    //求树左下角的值
    public int findBottomLeftValue(TreeNode node) {


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i==0){
                    ans = poll.val;
                }if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }

        }
        return ans;
    }

}
