package KM;

import com.google.common.base.Strings;

import java.util.*;
import java.util.stream.Collectors;

public class E14 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//数量
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
        }
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = a[i] + s[i - 1];
        }


        int x = sc.nextInt();
        int y = sc.nextInt();
        long res = 0;
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        res = Math.min(s[n] - s[y - 1] + s[x - 1], s[y - 1] - s[x - 1]);
        System.out.println(res);

    }


    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int maxn = 1010;
            long[][] s = new long[maxn][maxn];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    s[i][j] = sc.nextLong();
                    s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
                }
            }

            long ans = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                ans = Math.min(ans, ABS(s[i][m], s[n][m] - s[i][m]));
            }
            for (int j = 1; j <= m; j++) {
                ans = Math.min(ans, ABS(s[n][j], s[n][m] - s[n][j]));
            }

            System.out.println(ans);
        }

        private static long ABS(long a, long b) {
            return a - b > 0 ? a - b : b - a;
        }


    }

    public static class Main1 {


        public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);
            int q = sc.nextInt();
            while (q-->0){
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[] a = new int[n];
                int[] b = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();

                }
                for (int i = 0; i < n; i++) {
                    b[i] = sc.nextInt();
                }

                Arrays.sort(a);
                Arrays.sort(b);
                boolean flag = true;
                for (int i = 0; i < n ; i++) {
                    int cur = a[i] + b[n-1-i];
                    if(cur > m || cur < 1){
                        flag = false;
                        break;
                    }
                }

                System.out.println(flag ? "Yes" : "No");
            }


        }
    }


    public static class Main2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] s = scanner.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String row = scanner.nextLine();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = row.charAt(j);
                }
            }


            int count = count(matrix);
            System.out.println(count);
        }


        public static int count(char[][] matrix) {
            int count = 0;
            int n = matrix.length;
            int m = matrix[0].length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    int zeros = 0, ones = 0;
                    for (int k = i; k < i + 2; k++) {
                        for (int l = j; l < j + 2; l++) {
                            if (matrix[k][l] == '0') {
                                zeros++;
                            } else if (matrix[k][l] == '1') {
                                ones++;
                            }
                        }
                    }
                    if (zeros == ones) {
                        count++;
                    }
                }
            }
            return count;
        }


    }


    public static class Main3 {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            String s = scanner.next();

            int deleteCount = 0;
            for (int i = 0; i < n; ) {
                if (isEvenPalindrome(s, i)) {
                    // 找到一个长度为偶数的回文子串，删除其中一个字符
                    s = s.substring(0, i) + s.substring(i + 1);
                    n--;
                    deleteCount++;
                } else {
                    i++;
                }
            }

            System.out.println(deleteCount);
        }

        // 检查从索引start开始的子串是否为偶数长度的回文串
        private static boolean isEvenPalindrome(String s, int start) {
            int end = start + 1;
            while (end < s.length() && s.charAt(start) == s.charAt(end)) {
                end++;
            }
            return end - start >= 2;
        }


    }


}
