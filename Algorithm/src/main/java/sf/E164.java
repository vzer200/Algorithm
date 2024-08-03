package sf;

import java.util.ArrayList;

public class E164 {
    public int maximumGap(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min,  nums[i]);
        }
        int bucketNum = (max - min) / nums.length + 1;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(bucketNum);//创造桶
        for (int i = 0; i < bucketNum; i++) {
            arrayLists.add(new ArrayList<>());//初始化每个桶
        }



        return 0;
    }

}
