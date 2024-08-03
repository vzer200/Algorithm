package sf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class E169 {
    public static int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }

        }
        Integer key = null;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            Integer value = entry.getValue();
            if(value>nums.length/2){
                key = entry.getKey();
                break;
            }
        }

        return key;
    }

    public static void main(String[] args) {
        int[] nums=  {3,2,3};
        majorityElement(nums);
    }

}
