package sf;

public class E1143 {
    //最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] a = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1==c2) {
                    //相同字符对角线加一
                    a[i][j] = a[i-1][j-1]+1;
                }else {
                    //不同字符则上一列或者上一行取最大值
                    a[i][j] = Integer.max(a[i-1][j],a[i][j-1]);
                }
            }
        }

        return a[m][n];
    }
}
