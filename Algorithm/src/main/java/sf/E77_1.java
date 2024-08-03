package sf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E77_1 {

    //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    //经典回溯算法 本质暴力
    public static List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> res = new ArrayList<>();
        reverse(1,n,k,res, new LinkedList<>());
        return  res;
    }


    public static void reverse(int left,int n ,int k,List<List<Integer>> res,LinkedList<Integer> stack){

        if (stack.size()==k){
            res.add(new ArrayList<>(stack));
        }


        for (int i = left; i <= n; i++) {
            if (k-stack.size()>n-i){
                continue;
            }
            stack.push(i);
            reverse(i+1,n,k,res,stack);
            stack.pop();

        }

    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

}
