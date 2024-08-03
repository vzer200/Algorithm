package sf;

import java.util.LinkedList;

public class E55 {
    public static boolean canJump(int[] nums) {

        int[] dp = new int[nums.length];
        //dp[i]的意思是，从0到i的任意一点出发能到达的最远位置
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1]<i){
                return false;
            }

            dp[i] = Math.max(dp[i-1],nums[i]+i);
            if (dp[i]>=nums.length-1){
                return true;
            }


        }

        return dp[nums.length-1]>=nums.length-1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        canJump(nums);

    }




}
