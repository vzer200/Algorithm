package sf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class E39 {
    //组合总数
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        reverse(0, candidates, target, result, new LinkedList<>());
        return result;
    }

    private void reverse(int index, int[] candidates, int target, ArrayList<List<Integer>> result, LinkedList<Integer> stack) {

        if (target==0){
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            stack.push(candidates[i]);
            reverse(i+1,candidates,target-candidates[i],result,stack);
            stack.pop();
        }

    }


}
