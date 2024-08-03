package sf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E216 {
    //组合总和3
    public List<List<Integer>> combinationSum3(int k, int n) {
        //k个数的和为n
        //数字范围1-9
        //每个数字只能用一次
        List<List<Integer>> result = new ArrayList<>();
        reverse(1, k, n, result, new LinkedList<Integer>());
        return result;
    }

    private void reverse(int start, int k, int n, List<List<Integer>> result, LinkedList<Integer> stack) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }
        if (n<0){
            return;
        }

        for (int i = start; i < 10; i++) {

            stack.push(i);
            reverse(i + 1, k - 1, n - i, result, stack);
            stack.pop();
        }
    }
}
