package sf;

import java.util.*;

public class E128 {
    public static int longestConsecutive(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        //大致思路:排序去重计数
        Arrays.sort(nums);
        //用LinkedHashSet可以使得遍历元素的顺序和与插入的顺序相同
        //如果用hashset的话插入顺序不同就无法运用这个算法排序了

        Set<Integer> set  = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int pre = Integer.MIN_VALUE;
        int count  = 1;
        for (Integer i : set) {
            if (i-pre==1){
                count++;
            }else {
                count=1;
            }
            pre = i;
            res = Math.max(res,count);
        }
        return res;
    }

    public static void main(String[] args) {
        longestConsecutive3(new int[]{0,0});
    }








    public static int longestConsecutive1(int[] nums) {

            if(nums.length ==0){
                return 0;
            }
            Arrays.sort(nums);
            int count = 1 ;
            int ans = 1;
            int pre = 1;
            int max = 0;
            for(int i = 1;i<nums.length;i++){
                if(nums[i]-nums[i-1]==count){
                    ans++;
                }else{
                    max  = Math.max(pre,ans);
                    pre = ans;
                    ans = 1 ;
                }
            }
        max  = Math.max(max,ans);
            return max;

    }


    public static int longestConsecutive3(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        int count = 1;
        int max = 0;
        for(int i = 1; i<nums.length;i++){
            if(nums[i]-pre==1){
                count++;
            }else if(nums[i]==pre){
                pre =nums[i];
                continue;
            }else{
                count = 0;
            }
            max = Math.max(max,count);
            pre =nums[i];
        }
        max = Math.max(max,count);

        return max;
    }
}
