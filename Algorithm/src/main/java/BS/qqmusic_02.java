package BS;

import java.util.LinkedList;
import java.util.Queue;

public class qqmusic_02 {

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class s {
    public TreeNode completeBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 使用队列进行广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 使用队列保存最先遇到的节点，进行补全
        Queue<TreeNode> nodesToFill = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // 如果当前节点有空缺子节点，加入到待补全队列
            if (current.left == null || current.right == null) {
                nodesToFill.offer(current);
            }

            // 如果有左子节点，继续遍历，否则记录该节点等待补全
            if (current.left != null) {
                queue.offer(current.left);
            }

            // 如果有右子节点，继续遍历，否则记录该节点等待补全
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        // 补全缺失的节点
        while (!nodesToFill.isEmpty()) {
            TreeNode node = nodesToFill.poll();

            if (node.left == null) {
                node.left = new TreeNode(1);
            } else if (node.right == null) {
                node.right = new TreeNode(1);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        // 创建测试用例：{1,#,1,1}
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);

        s solution = new s();
        TreeNode completedTree = solution.completeBinaryTree(root);

        // 输出补全后的二叉树结构（使用BFS遍历输出）
        printTree(completedTree);
    }

    // 辅助函数：广度优先打印树
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
}
