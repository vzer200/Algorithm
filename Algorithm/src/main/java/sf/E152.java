package sf;

public class E152 {
    public static int maxProduct(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 1;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1]*nums[i-1],nums[i-1]);
            res = Math.max(res,dp[i]);
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        maxProduct(new int[]{-2,3,-4});
    }
}
