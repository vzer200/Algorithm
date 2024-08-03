package sf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E136 {
    //只出现一次的数字
    public static int singleNumber1(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer count = map.get(i);
            count = count==null? 1: ++count;
            map.put(i,count);
        }
        for (Integer integer : map.keySet()) {
            Integer count = map.get(integer);
            if (count==1){
                return integer;
            }
        }
        return -1;
    }
    public static int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
