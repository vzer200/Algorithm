package sf;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E216_1 {

    //找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
    //
    //只使用数字1到9
    //每个数字 最多使用一次
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        reverse(1,k,n,res,new LinkedList<>());
        return res;
    }

    private static void reverse(int left,int k, int n, List<List<Integer>> res, LinkedList<Integer> stack) {

        if (k==0&&n==0){
            res.add(new ArrayList<>(stack));
        }
        if (n<0){
            return;
        }

        for (int i = left; i <=9; i++) {
            stack.push(i);
            reverse(i+1,k-1,n-i,res,stack);
            stack.pop();
        }

    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }
}
