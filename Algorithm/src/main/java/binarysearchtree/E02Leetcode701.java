package binarysearchtree;

/**
 * 新增节点 (题目前提：val 一定与树中节点不同)
 */
public class E02Leetcode701 {

    /*
            val=1

            5
           / \
          2   6
           \
            3
     */
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node==null){
            return new TreeNode(val);
        }
      if (val<node.val){
          node.left = insertIntoBST(node.left, val);

      } else if (val>node.val) {
          node.right = insertIntoBST(node.right,val);
      }
      return node;
    }


    public static TreeNode searchBST(TreeNode node, int val) {
        if(node==null){
            return null;
        }
        if(val<node.val){
            return searchBST(node.left,val);
        }else if(val>node.val){
            return searchBST(node.right,val);
        }else{
            return node;
        }


    }

    public static void main(String[] args) {

       /* TreeNode root = new TreeNode(5, new TreeNode(2, null, new TreeNode(3)), new TreeNode(6));
        new E02Leetcode701().searchBST(root, 3);*/
                     //            4
                  //       2              6
                 //   1        3     5        7

        // 创建二叉搜索树的根节点
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // 测试用例 1
        int val1 = 2;
        System.out.println(searchBST(root, val1));



    }
}
