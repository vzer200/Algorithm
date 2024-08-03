package sf;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E501 {
    //二叉搜索树中的众数
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dg(root,res);
        int pre = res.get(0);
        int count = 1;
        int maxCount =1;
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            if (pre== res.get(i)){
                count+=1;
            }else {
                count=1;
            }
            if (count==maxCount){
                ans.add(res.get(i));
            } else if (count>maxCount){
                maxCount = count;
                // 重新更新 ans
                ans.clear();
                ans.add(res.get(i));

            }
            pre = res.get(i);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public void dg(TreeNode node, List<Integer> res){

        if (node==null){
            return ;
        }
        dg(node.left,res);
        res.add(node.val);
        dg(node.right,res);

    }
}
