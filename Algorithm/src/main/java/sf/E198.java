package sf;

import java.util.Arrays;

public class E198 {
    //打家劫舍
    //如果当前偷窃金额小于上一列偷窃金额，则套用上一列金额
    //
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0],nums[1]);
        for (int i = 2; i < dp.length; i++) {
                dp[i]=Integer.max(dp[i-1],nums[i]+dp[i-2]);
        }

        return dp[dp.length-1];
    }


}
