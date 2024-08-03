package sf;

public class E48 {
    //旋转图像
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //先沿斜对角线翻转
        for(int i = 0;i < n;i ++)
            for(int j = 0;j < i;j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        //再沿垂直竖线翻转
        for(int i = 0;i < n;i ++)
            for(int j = 0, k = n - 1; j < k ; j++, k--){
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
            }
    }



    public static void main(String[] args) {
       int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
