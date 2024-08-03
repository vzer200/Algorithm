package BS;

import java.util.Scanner;

public class ZJ_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++){

                a[i] = sc.nextInt();
            }

            if (n <= 2) {
                System.out.println(0);
                continue;

            }

            int minChanges = Integer.MAX_VALUE; // 最小改变次数，初始化为最大整数值

            // 尝试所有可能的起始两个元素值
            for (int firstValue = -1; firstValue <= 1; firstValue++) {
                for (int secondValue = -1; secondValue <= 1; secondValue++) {
                    int changes = 0;
                    if (firstValue != 0) changes++; // 如果改变了第一个元素
                    if (secondValue != 0) changes++; // 如果改变了第二个元素

                    int first = a[0] + firstValue; // 实际的第一个元素值
                    int second = a[1] + secondValue; // 实际的第二个元素值
                    int d = second - first; // 公差

                    boolean flag = true;
                    for (int i = 2; i < n; i++) {
                        int temp = first + i * d; // 预期的元素值
                        int actualValue = Math.abs(temp - a[i]); // 实际与预期的差值
                        if (actualValue > 1) {
                            flag = false;
                            break;
                        }
                        changes += actualValue;
                    }

                    if (flag) {
                        minChanges = Math.min(minChanges, changes);
                    }
                }
            }

            System.out.println(minChanges == Integer.MAX_VALUE ? -1 : minChanges);
        }

    }
}
