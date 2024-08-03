package sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E77 {
    //组合
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int start = 1;
        reverse(start,n,k,result,new LinkedList<Integer>());
        return result;
    }

    private void reverse(int start, int n, int k, ArrayList<List<Integer>> result, LinkedList<Integer> stack) {
        if (stack.size()==k){
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i <=n ; i++) {
            //剪枝操作，总的组合数-固定组合数等于差的组合数  大于 最大的数-正在使用的数得到可选的组合数
            if (k-stack.size()>n-i+1){
                continue;
            }

            stack.push(i);
            reverse(i+1,n,k,result,stack);
            stack.pop();
        }
    }
}
