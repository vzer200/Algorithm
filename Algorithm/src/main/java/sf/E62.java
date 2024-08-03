package sf;

import java.util.Arrays;

public class E62 {
    //不同路径，动态规划
    //1 1 1 1 1 1 1
    //1 2 3 4 5 6 7
    //1 3 6 10 15 21 28

    //

    public int uniquePaths(int m, int n) {
        int[] a = new int[n];
        Arrays.fill(a, 1);
        for (int j = 1; j <m ; j++) {
            for (int i = 1; i <n ; i++) {
                a[i] = a[i] + a[i-1];
            }

        }
        return a[n-1];
    }
}
