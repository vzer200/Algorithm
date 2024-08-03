package BS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ZJ_08 {


    static List<List<Rat>> rats = new ArrayList<>();
    // 缓存记忆已求过的点
    static int[][][] dp = new int[101][101][101];

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        // 初始化地鼠列表
        for(int i=0; i<=100; i++){
            rats.add(new ArrayList<>());
        }

        // 输入地鼠信息
        for(int i=0;i<k;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int t = scanner.nextInt();
            int s = scanner.nextInt();
            rats.get(t).add(new Rat(x, y, t, s));
        }

        // 初始化dp数组
        for(int[][] a: dp){
            for(int[] b: a)
                Arrays.fill(b, -1);
        }
        dp[0][1][1] = 0;

        // 对每个时间点进行遍历
        for(int t=0; t<=100; t++){
            // 对地图上每个点进行遍历
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=m; j++) {
                    if(dp[t][i][j] == -1) continue;
                    // 查看当前地鼠位置和数量，并增加分数
                    for(Rat rat: rats.get(t)){
                        if(rat.x == i && rat.y == j){
                            dp[t][i][j] += rat.s;
                        }
                    }
                    // 计算下一秒可能去的位置
                    if(t < 100){
                        for(int x=-1;x<=1;x++){
                            for(int y=-1;y<=1;y++){
                                if(x*x + y*y > 1) continue;
                                int dx = x + i;
                                int dy = y + j;
                                if(dx < 1 || dy < 1 || dx > n || dy > m) continue;
                                dp[t+1][dx][dy] = Math.max(dp[t+1][dx][dy], dp[t][i][j]);
                            }
                        }
                    }
                }
            }
        }

        // 在结束时，找出得分最高的情况
        int max = 0;
        for(int i=1; i<=n; i++)
            for(int j=1; j<=m; j++)
                max = Math.max(max, dp[100][i][j]);

        System.out.println(max);
    }



    class Rat {
        int x, y, t, s;

        Rat(int x, int y, int t, int s) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.s = s;
        }
    }

}
