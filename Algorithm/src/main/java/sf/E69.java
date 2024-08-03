package sf;

public class E69 {
    //x的平方根
    //由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int index = 0;
        while (left <= right) {
            int m = (left + right) >> 1;
  //          int mm = m * m;
            if (x/m >= m) {
                left = m + 1;
                index = m;
            } else {
                right = m - 1;
            }
        }
        return index;
    }
}
