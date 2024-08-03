package sf;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

       Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode poll = queue.poll();
            while (size>0){
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                size--;
            }
            List<Integer> lever = new ArrayList<>();
            lever.add(poll.val);
            res.add(lever);
        }
        return res;
    }

}
