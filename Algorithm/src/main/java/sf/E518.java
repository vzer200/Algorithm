package sf;

import java.util.Arrays;

public class E518 {
    //零钱兑换2
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
