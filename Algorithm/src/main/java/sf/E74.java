package sf;

public class E74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int L = matrix[0].length;
        int H = matrix.length;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < L; j++) {
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
