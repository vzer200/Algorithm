package sf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E78 {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        reverse(nums,res,new LinkedList<>(),0);
        return res;
    }

    private static void reverse(int[] nums, List<List<Integer>> res, LinkedList<Integer> stack, int i) {
        if (i==nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }


        for (int j = i; j < nums.length; j++) {
            stack.push(nums[j]);
            reverse(nums,res,stack,j+1);
            stack.pop();

        }

    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets(nums);
    }
}
