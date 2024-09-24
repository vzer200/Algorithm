package BS;

public class J58_03 {
    public int numberOfWays(int startPos, int endPos, int k) {
        int MOD = 1000000007;
        int distance = Math.abs(endPos - startPos);
        if (distance > k || (k - distance) % 2 != 0) {
            return 0;
        }
        int stepsRight = (k + distance) / 2;
        return (int) (combination(k, stepsRight, MOD));
    }

    private long combination(int n, int k, int MOD) {
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        long inverseK = modInverse(factorial[k], MOD);
        long inverseNMinusK = modInverse(factorial[n - k], MOD);
        return factorial[n] * inverseK % MOD * inverseNMinusK % MOD;
    }

    private long modInverse(long a, int MOD) {
        return power(a, MOD - 2, MOD);
    }

    private long power(long x, long y, int MOD) {
        long result = 1;
        x = x % MOD;
        while (y > 0) {
            if (y % 2 == 1) {
                result = result * x % MOD;
            }
            y = y / 2;
            x = x * x % MOD;
        }
        return result;
    }

    public int numberOfWays2(int startPos, int endPos, int k) {
        int MOD = 1000000007;
        int maxOffset = 2000;
        int n = maxOffset * 2 + 1; // 总的位置范围
        int[] dp = new int[n];
        dp[startPos + maxOffset] = 1;

        for (int step = 1; step <= k; step++) {
            int[] nextDp = new int[n];
            for (int pos = 0; pos < n; pos++) {
                int ways = dp[pos];
                if (ways > 0) {
                    if (pos - 1 >= 0) {
                        nextDp[pos - 1] = (nextDp[pos - 1] + ways) % MOD;
                    }
                    if (pos + 1 < n) {
                        nextDp[pos + 1] = (nextDp[pos + 1] + ways) % MOD;
                    }
                }
            }
            dp = nextDp;
        }

        return dp[endPos + maxOffset];
    }

    public int numberOfWays3(int startPos, int endPos, int k) {
        int MOD = 1000000007;
        int maxOffset = 2000;
        Integer[][] array = new Integer[2 * maxOffset + 1][k + 1];
        return dfs(startPos, k, endPos, array, MOD, maxOffset);
    }

    private int dfs(int curr, int steps, int endPos, Integer[][] array, int MOD, int maxOffset) {
        if (steps == 0) {
            return curr == endPos ? 1 : 0;
        }
        if (array[curr + maxOffset][steps] != null) {
            return array[curr + maxOffset][steps];
        }
        int left = dfs(curr - 1, steps - 1, endPos, array, MOD, maxOffset);
        int right = dfs(curr + 1, steps - 1, endPos, array, MOD, maxOffset);
        int res = (left + right) % MOD;
        array[curr + maxOffset][steps] = res;
        return res;
    }
}
