package BS;

import java.util.Scanner;

public class J360_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int maxLength = findMaxConsecutiveLength(arr, n);

            int result = maxLength + 1; // 将最大长度加 1
            System.out.println(result);
        }
    }

    public static int findMaxConsecutiveLength(int[] arr, int n) {
        int maxLength = 1; // 最长连续相同元素的长度
        int currentLength = 1; // 当前连续相同元素的长度

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }
}
