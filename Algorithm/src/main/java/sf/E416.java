package sf;

public class E416 {
    public static boolean canPartition(int[] nums) {
        int[] dp = new int[nums.length];
        int num  = 0 ;
        dp[0] = nums[0];
        for(int i = 0; i<nums.length;i++){
            num+=nums[i];
        }
        for(int i = 1; i<nums.length;i++){
            dp[i] = dp[i-1]+nums[i];
            if(dp[i] == num-nums[nums.length-i-1]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        canPartition(nums);
    }
}
