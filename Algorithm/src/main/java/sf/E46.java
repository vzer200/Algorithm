package sf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E46 {
    //全排列
    //回溯解决
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        reverse(nums,new LinkedList<>(),new boolean[nums.length],result);
        return result;
    }

    private static void reverse(int[] nums, LinkedList<Integer> stack, boolean[] booleans, List<List<Integer>> result) {
        if (stack.size()==nums.length){
             result.add(new ArrayList<>(stack));
             return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!booleans[i]){
                stack.push(nums[i]);
                booleans[i] = true;
                reverse(nums,stack,booleans,result);
                booleans[i] = false;
                stack.pop();
            }

        }
    }


}
