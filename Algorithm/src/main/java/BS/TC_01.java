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

        // 遍历所有可能的目标字符 '0' 到 '9'
        for (char target = '0'; target <= '9'; target++) {
            int[] count = new int[10];
            int currentSteps = 0;

            // 初始化窗口
            for (int i = 0; i < k; i++) {
                int diff = Math.abs(s.charAt(i) - target);
                count[s.charAt(i) - '0']++;
                currentSteps += diff;
            }

            if (isWindowValid(count, target)) {
                minSteps = Math.min(minSteps, currentSteps);
            }

            // 滑动窗口
            for (int i = k; i < n; i++) {
                // 移出窗口的字符
                int outChar = s.charAt(i - k) - '0';
                currentSteps -= Math.abs(s.charAt(i - k) - target);
                count[outChar]--;

                // 加入窗口的字符
                int inChar = s.charAt(i) - '0';
                currentSteps += Math.abs(s.charAt(i) - target);
                count[inChar]++;

                // 检查窗口是否合法并更新最小步骤
                if (isWindowValid(count, target)) {
                    minSteps = Math.min(minSteps, currentSteps);
                }
            }
        }

        return minSteps;
    }

    // 检查窗口是否合法
    private static boolean isWindowValid(int[] count, char target) {
        // 检查目标字符是否可以合法转换
        if (target == '0' && count[0] > 0) return false; // '0' 不能减少
        if (target == '9' && count[9] > 0) return false; // '9' 不能增加
        return true;
    }
}
