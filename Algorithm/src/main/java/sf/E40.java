package sf;

import java.util.*;

public class E40 {
    //组合总数2
    public List<List<Integer>> combinationSum2(int[] n, int k) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(n);

        reverse(0, n, k, new boolean[n.length],result, new LinkedList<>());
        return result;

    }
    private void reverse(int start, int[] candidates, int target,boolean[] v, ArrayList<List<Integer>> result, LinkedList<Integer> stack) {

        if (target == 0) {
            result.add(new ArrayList<>(stack));
        }


        for (int i = start; i < candidates.length; i++) {
            if (i>0&&candidates[i]==candidates[i-1]&&!v[i-1]){
                continue;
            }
            if (target<candidates[i]){
                continue;
            }

            stack.push(candidates[i]);
            v[i] = true;
            reverse(i+1, candidates, target-candidates[i], v,result, stack);
            v[i] = false;
            stack.pop();

        }


    }
}
