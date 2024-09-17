package BS;

import java.util.Scanner;

public class TC_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 字符串长度
        int k = scanner.nextInt(); // 子串长度
        scanner.nextLine(); // 读取剩余行
        String s = scanner.nextLine(); // 输入的字符串

        if (k > n) {
            System.out.println(0);
        } else {
            System.out.println(minMagicSteps(k, n, s));
        }
    }

    public static int minMagicSteps(int k, int n, String s) {
        int minSteps = Integer.MAX_VALUE;

        for (char target = '0'; target <= '9'; target++) {
            int[] cost = new int[n];

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == target) {
                    cost[i] = 0;
                } else if (c < target) {
                    if (c == '9') {
                        cost[i] = Integer.MAX_VALUE;
                    } else {
                        cost[i] = target - c;
                    }
                } else {
                    if (c == '0') {
                        cost[i] = Integer.MAX_VALUE;
                    } else {
                        cost[i] = c - target;
                    }
                }
            }

            int totalCost = 0;
            int invalidCount = 0;
            for (int i = 0; i < n; i++) {
                if (cost[i] == Integer.MAX_VALUE) {
                    invalidCount++;
                } else {
                    totalCost += cost[i];
                }

                if (i >= k) {
                    if (cost[i - k] == Integer.MAX_VALUE) {
                        invalidCount--;
                    } else {
                        totalCost -= cost[i - k];
                    }
                }

                if (i >= k - 1 && invalidCount == 0) {
                    minSteps = Math.min(minSteps, totalCost);
                }
            }
        }

        return minSteps;
    }
}
