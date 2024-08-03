package sf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E167 {
    // 9 - 2
    //两数之和 输入有序数组
    public int[] twoSum2(int[] numbers, int target) {
        //numbers下标从1开始
        //只有唯一答案
        //不可以使用相同元素， 递增数组
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<numbers.length; i++) {
            if (map.containsKey(target-numbers[i]))
                return new int[]{map.get(target-numbers[i]),i+1};
            map.put(numbers[i],i+1);
        }
        return new int[0];
    }

    public int[] twoSum(int[] numbers, int target) {
        //双指针
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            if (numbers[left]+numbers[right]>target){
                right--;
            }else if (numbers[left]+numbers[right]<target){
                left++;
            }else {
                //找到目标
                return new int[]{left+1,right+1};
            }

        }
        return new int[0];

    }
















    public static int[] twoSum3(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if (sum>target){
                right--;
            }else if (sum<target){
                left++;
            }else {
                break;
            }
        }

        return new int[] {left+1,right+1};
    }

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        twoSum3(a,9);
    }



}
