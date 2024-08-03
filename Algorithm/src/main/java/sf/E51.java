package sf;

import java.util.*;

public class E51 {
    //n皇后
    public List<List<String>> solveNQueens(int n) {
        //i行j列
        List<List<String>> result = new ArrayList<>();
        char[][] c = new char[n][n];
        for (char[] chars : c) {
            Arrays.fill(chars, '.');
        }

        boolean[] ba = new boolean[n];
        boolean[] bb = new boolean[2 * n - 1];
        boolean[] bc = new boolean[2 * n - 1];

        reverse(0, n, c, ba, bb, bc, result);
        return result;
    }


    private void reverse(int i, int n, char[][] c, boolean[] ba, boolean[] bb, boolean[] bc, List<List<String>> result) {
        if (i == n) {
            result.add(bh(c));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (ba[j] || bb[i + j] || bc[n - 1 - (i - j)]) {
                continue;
            }

            c[i][j] = 'Q';
            ba[j] = bb[i + j] = bc[n - 1 - (i - j)] = true;
            reverse(i + 1, n, c, ba, bb, bc, result);
            c[i][j] = '.';
            ba[j] = bb[i + j] = bc[n - 1 - (i - j)] = false;

        }

    }

    private List<String> bh(char[][] c) {
        List<String> s = new ArrayList<>();
        for (char[] chars : c) {
            s.add(new String(chars));
        }
        return s;
    }
}
