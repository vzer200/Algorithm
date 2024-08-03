package sf;

public class E96 {
    //不同的二叉搜索树
    //卡特兰数

    //c(0)=1;
    //c(1)=1;
    //c(2)=2;
    //c(3)=5;

    //n=3
    //i=2
    //dp[2]=dp[2]+dp[0]*dp[1];
    //dp[2]=dp[2]+dp[1]*dp[0];
    //dp[1]=dp[1]+dp[2]*dp[0];
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {//第i个卡特兰数的拆分
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
