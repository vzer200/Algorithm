package BS;

import java.util.Scanner;

public class xm_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] timeA = new int[n];
        int[] timeB = new int[n];

        for(int i = 0 ; i < n; i++){
            timeA[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n; i++){
            timeB[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;

        int minA1 = Integer.MAX_VALUE, minA2 = Integer.MAX_VALUE;
        int minB1 = Integer.MAX_VALUE, minB2 = Integer.MAX_VALUE;
        int indexA = -1, indexB = -1;

        // 找到最小和次小的时间及其对应的索引
        for (int i = 0; i < n; i++) {
            if (timeA[i] < minA1) {
                minA2 = minA1;
                minA1 = timeA[i];
                indexA = i;
            } else if (timeA[i] < minA2) {
                minA2 = timeA[i];
            }

            if (timeB[i] < minB1) {
                minB2 = minB1;
                minB1 = timeB[i];
                indexB = i;
            } else if (timeB[i] < minB2) {
                minB2 = timeB[i];
            }
        }

        // 使用不同面包机制作
        if (indexA != indexB) {
            min = Math.min(min, Math.max(minA1, minB1));
        } else {
            min = Math.min(min, Math.max(minA1, minB2));
            min = Math.min(min, Math.max(minA2, minB1));
        }

        // 使用同一个面包机制作
        for(int i = 0; i < n; i++){
            min = Math.min(min, timeA[i] + timeB[i]);
        }

        System.out.println(min);
    }


    //public static void main(String[] args) {
    //        Scanner scanner = new Scanner(System.in);
    //
    //        int n = scanner.nextInt(); // 面包机的数量
    //        int[] timeA = new int[n];  // 制作面包a的时间
    //        int[] timeB = new int[n];  // 制作面包b的时间
    //
    //        for (int i = 0; i < n; i++) {
    //            timeA[i] = scanner.nextInt();
    //        }
    //
    //        for (int i = 0; i < n; i++) {
    //            timeB[i] = scanner.nextInt();
    //        }
    //
    //        int minTime = Integer.MAX_VALUE;
    //
    //        // 情况1：使用不同的面包机制作a和b
    //        for (int i = 0; i < n; i++) {
    //            for (int j = 0; j < n; j++) {
    //                if (i != j) {
    //                    minTime = Math.min(minTime, Math.max(timeA[i], timeB[j]));
    //                }
    //            }
    //        }
    //
    //        // 情况2：使用同一台面包机制作a和b
    //        for (int i = 0; i < n; i++) {
    //            minTime = Math.min(minTime, timeA[i] + timeB[i]);
    //        }
    //
    //        System.out.println(minTime);
    //    }
}
