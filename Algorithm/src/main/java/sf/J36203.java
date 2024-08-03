package sf;


import java.util.LinkedList;
import java.util.Queue;

public class J36203 {
    public int minimumMoves(int[][] grid) {

        //G
        int n = grid.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int[] count = new int[9];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && Math.abs(rowSum[i] - colSum[j]) <= 1) {
                    ans += Math.abs(rowSum[i] - colSum[j]);
                }
            }
        }

        return ans;
    }
}
