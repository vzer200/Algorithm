package sf;

import java.util.HashMap;
import java.util.Map;

public class E454 {

    //四数相加


    public static void main(String[] args) {
        int[]nums1 = {1,2,4};
        int[]nums2 = {-1,2};
        int[]nums3 = {-1,2};
        int[]nums4 = {3};
        int i = fourSumCount(nums1, nums2, nums3, nums4);
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
        for (int u : nums1) {
            for (int v : nums2) {
               m1.put(u+v,m1.getOrDefault(u+v,0)+1);
            }
        }
        int ans = 0;
        for (int w : nums3) {
            for (int x : nums4) {
                if (m1.containsKey(-w -x)){
                    ans=ans+m1.get(-w -x);
                }
            }
        }

        return ans;
    }

}
