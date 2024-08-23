package BS;

import java.util.Scanner;

public class dj_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] block = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                block[i][j] = scanner.nextInt();
            }
        }

        System.out.println(robotCount(block));
    }

    public static int robotCount(int[][] block) {
        int m = block.length;
        int n = block[0].length;
        boolean[][] visited = new boolean[m][n];

        // 只从 (0,0) 位置开始进行 DFS
        return dfs(block, visited, 0, 0, m, n);
    }

    public static int dfs(int[][] block, boolean[][] visited, int x, int y, int m, int n) {
        // 边界检查，越界或者遇到障碍物或已经访问过的节点，返回 0
        if (x < 0 || x >= m || y < 0 || y >= n || block[x][y] == 1 || visited[x][y]) {
            return 0;
        }

        // 标记当前节点为已访问
        visited[x][y] = true;

        // 计数当前节点
        int count = 1;

        // 递归遍历四个方向（上、下、左、右）
        count += dfs(block, visited, x - 1, y, m, n); // 上
        count += dfs(block, visited, x + 1, y, m, n); // 下
        count += dfs(block, visited, x, y - 1, m, n); // 左
        count += dfs(block, visited, x, y + 1, m, n); // 右

        return count;
    }
}
