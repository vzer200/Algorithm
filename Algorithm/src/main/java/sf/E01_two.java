package sf;

import java.util.HashMap;
import java.util.Map;

public class E01_two {
    public static int[] twoSum(int[] nums, int target) {

        //思路：我们将遍历过的数以及它的索引放入一个新map的集合，然后遍历下一个数的时候，用target减去上一个数
        //如果得到的数是第二个数，那么就将他的索引放入集合,如果不是则继续遍历下一个
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {

            if (target-map.get(0)==nums[i]){
                map.put(nums[i],i);
            }

        }
        return new int[]{1};
    }
}
