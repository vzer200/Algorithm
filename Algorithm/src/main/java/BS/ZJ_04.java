package BS;

import java.util.Scanner;

public class ZJ_04 {

    static int MOD = (int) Math.pow(10, 9) + 7;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        long[][] dp = new long[n + 1][k + 1];

        dp[2][0] = 1; //初始条件，第一个数字小于第二个数字，因此只有1种排列

        for(int i = 3; i <= n; ++i) {
            dp[i][0] = 1; //所有数字递增排列的逆序对为0
            for(int j = 1; j <= k; ++j) {
                for(int m = 0; m < i && m <= j; ++m) {//m是新加入的数字造成的逆序对
                    dp[i][j] = (dp[i][j] + dp[i-1][j-m]) % MOD;
                }
            }
        }

        long result = 0;
        // 结果是所有逆序对小于等于k的情况的总和
        for(int i = 0; i <= k; ++i) {
            result = (result + dp[n][i]) % MOD;
        }

        System.out.println(result);
    }

}
