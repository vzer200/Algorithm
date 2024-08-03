package sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E37 {
    //解数独

    public void solveSudoku(char[][] board) {

        int n = board.length;
        boolean[][] ca = new boolean[n][n];//行冲突
        boolean[][] cb = new boolean[n][n];//列冲突
        boolean[][] cc = new boolean[n][n];//3x3宫冲突
        //初始化冲突
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.') {
                    //表示找到了数字 记录冲突
                    ca[i][c - '1'] = cb[j][c - '1'] = cc[i / 3 * 3 + j / 3][c - '1'] = true;
                }

            }
        }

        reverse(0, 0, board, ca, cb, cc);

    }

    private boolean reverse(int i, int j, char[][] board, boolean[][] ca, boolean[][] cb, boolean[][] cc) {
        //遍历操作 找到空格
        while (board[i][j] != '.') {
            //表示找到了数字
            if (++j >= board.length) {
                i++;
                j = 0;
            }
            if (i>=board.length){
                //表示全部找完了
                return true;
            }

        }


        for (int x = 1; x <= 9; x++) {
            if (ca[i][x-1]||cb[j][x-1]||cc[i/3*3+j/3][x-1]){
                continue;
            }
           board[i][j] = (char) (x + '0');//将字符填入
            ca[i][x-1] = cb[j][x-1] = cc[i/3*3+j/3][x-1] = true;
            if (reverse(i,j,board,ca,cb,cc)) {
                return true;
            }
            board[i][j] = '.';
            ca[i][x-1] = cb[j][x-1] = cc[i/3*3+j/3][x-1] = false;

        }
        return false;
    }





}
