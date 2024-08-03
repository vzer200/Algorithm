package sf;

public class E73 {

    public void setZeroes(int[][] matrix) {

        //二维数组的行与列
        int m = matrix.length; //行
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] columns = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    //如果当前元素为0 将当前行与列的元素都置为0;
                    //假设现在元素0 i是1 j是1 将行置为0 i1  j0 j2
                    //列 j1 i0 i2;
                    row[i] = columns[j] = true;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i]||columns[j]){
                    matrix[i][j] = 0;
                }
            }
        }


    }







    public void setZeroes2(int[][] matrix) {

        //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
        //螺旋矩阵
        int m = matrix.length; //行
        int n = matrix[0].length; //列

        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j]==0){
                    row[i] = column[j] = true;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i]||column[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }


}
