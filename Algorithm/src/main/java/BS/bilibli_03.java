package BS;

import java.util.LinkedList;
import java.util.Scanner;

public class bilibli_03 {
    static int minDiff;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // 初始化最小差值
            minDiff = Integer.MAX_VALUE;

            // 从第一个数字开始递归
            dfs(arr, n, m, 1, arr[0],new LinkedList<>());
            dfs(arr, n, m, 1, -arr[0],new LinkedList<>());

            System.out.println(minDiff);
        }

        scanner.close();
    }

    // 深度优先搜索函数
    public static void dfs(int[] arr, int n, int m, int index, int currentSum, LinkedList<Integer> stack) {
        // 当到达最后一个元素时，检查当前的和
        if (index == n) {
            minDiff = Math.min(minDiff, Math.abs(currentSum - m));
            return;
        }

        // 继续向下递归，加和减两种情况
        dfs(arr, n, m, index + 1, currentSum + arr[index],stack);
        dfs(arr, n, m, index + 1, currentSum - arr[index],stack);
    }
}
