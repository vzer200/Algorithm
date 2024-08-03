package BS;

import java.util.Arrays;
import java.util.Scanner;



public class ZJ_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            Arrays.sort(a);
            if (k > n || (k < n && a[n - k - 1] == a[n - k])) {
                //想象一下这个问题的视觉表示。逆向思考，利用已排序的边长数组a，最大的k个数一定是覆盖点的正方形的边长。
                // 然后，我们关注的是能否找到一个点，只被这k个最大的正方形覆盖。
                // 所以，如果正方形的数量多于k，我们不希望第n-k个正方形的边长和第n - k - 1个正方形的边长相同，
                // 因为如果它们相同，那么也就没有办法找到一个点只被最大的k个正方形覆盖（它至少会被最大的k+1个正方形覆盖）。
                // 这就是为什么我们要检查a[n - k - 1] == a[n - k]的原因。

                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

        in.close();
    }
}
