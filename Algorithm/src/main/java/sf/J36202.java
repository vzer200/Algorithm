package sf;

import java.util.LinkedList;
import java.util.Queue;

public class J36202 {
    //G
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[1001][1001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1], step = cell[2];
            if (x == fx && y == fy) return true;
            for (int[] direction : directions) {
                int newX = x + direction[0], newY = y + direction[1];
                if (newX >= 0 && newX < 1001 && newY >= 0 && newY < 1001 && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY, step + 1});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }
}
