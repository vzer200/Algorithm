package sf;

public class j36204 {
    //G

    public long kTransformation(String s, String t, long k) {
        if (s.equals(t)) {
            return 0;
        }
        int n = s.length();
        int m = t.length();
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                dp[i][j] %= 1000000007;
            }
        }
        return dp[n][m];
    }
}
