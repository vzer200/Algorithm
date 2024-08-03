package sf;

public class E240 {


    //暴力算法
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;//行
        int n = matrix[0].length;//列

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }


    //二分查找

    public boolean searchMatrix2(int[][] matrix, int target) {

        for (int[] ints : matrix) {
            int index = twoCheck(ints, target);
            if (index>=0){
                return true;
            }
        }
        return false;
    }


    public static int twoCheck(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        while (left <= right) {
            //二分查找
            int mid = (left + right) >>> 1;
            if (num[mid] > target) {
                right = mid - 1;
            } else if (num[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {-5};
        int i = twoCheck(num, -5);
        System.out.println(i);
    }
}
