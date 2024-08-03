package sf;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class E79 {

    public int rows;
    public int cols;
    public int w;
    public boolean[][] visited;
    public char[] L;

    //单词搜索

    //回溯法
    // 先定位 一个 字符 然后 寻找相邻位置的字符是否符合
    public boolean exist(char[][] board, String word) {

        L = word.toCharArray();
        rows = board.length; // 获取行数
        cols = board[0].length; // 获取列数
        w = word.length();
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //判断是否符合相邻逻辑
                boolean res = D(board, i, j, 0);
                if (res)
                    return true;
            }
        }
        return false;
    }

    private boolean D(char[][] board, int i, int j, int index) {
        if (index >= w) {
            return true;
        }
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            //超出索引范围
            return false;
        }
        if (board[i][j] != L[index] || visited[i][j]) {
            //表示下一个方块里的字符与字符串中所求字符不同
            return false;
        }


        //0代表word 的index
        visited[i][j] = true;
        boolean success = D(board, i + 1, j, index + 1) || D(board, i, j + 1, index + 1) ||
                D(board, i - 1, j, index + 1) || D(board, i, j - 1, index + 1);
        visited[i][j] = false;
        return success;
    }


}
