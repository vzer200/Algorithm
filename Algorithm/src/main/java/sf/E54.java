package sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        //总结一下 思路非常牛逼 总体理解下来
        //四个边界收缩的方法

        if (matrix.length == 0)
            return new ArrayList<Integer>();

        int m = matrix.length;//行
        int n = matrix[0].length;
        Integer[] res = new Integer[m * n];
        //运用边界收缩法
        //左边界 l  右边界 r 上边界 t 下边界 b
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;
        int index = 0;
        while (true) {

            //总体顺序是从左到右 从上到下 从右到左 从下到上 依次循环
            //你在走完上一步的时候同时要保证下一步有得走 没得走的情况：边界相撞了
            //如果没得走 就需要break了
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                res[index++] = matrix[i][r];
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                res[index++] = matrix[b][i];
            }
            if (--b < t) break;
            for (int i = b; i >= t; i--) {
                res[index++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return Arrays.asList(res);
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();

        //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

        //设置四个边界
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0; //左边界
        int r = n - 1;//右边界
        int t = 0;//上边界
        int b = m - 1;//下边界
        Integer[] res = new Integer[m * n];
        int index = -1;

        while (true) {

            //给个死循环 跳出死循环的条件是边界相撞
            //螺旋返回值 先是从左到右 然后上到下 右到左 下到上
            for (int i = l; i <= r; i++) {
                res[++index] = matrix[t][i];
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                res[++index] = matrix[i][r];
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                res[++index] = matrix[b][i];
            }
            if (--b<t) break;
            for (int i = b; i >=t; i--) {
                res[++index] = matrix[i][l];
            }
            if (++l>r)break;
        }

        return Arrays.asList(res);
    }









    public List<Integer> spiralOrder3(int[][] matrix) {

        //顺时针螺旋旋转返回矩阵元素
        //思路:设置四个边界,逐渐收缩 一旦边界相撞 代表收缩到尽头了 返回
        int m = matrix.length;//行
        int n = matrix[0].length;
        int l = 0;//左边界
        int r = n-1;//左边界
        int t = 0;//上边界
        int b = m-1;//下边界
        int index = -1;
        Integer[] res = new Integer[m * n];

       while (true) {

           for (int i = l; i <= r; i++) {
               res[++index] = matrix[t][i];
           }
           //下一步是否会撞
           if (++t>b)break;

           for (int i = t; i <= b; i++) {
               res[++index] = matrix[i][r];
           }
           if (--r<l)break;

           for (int i = r; i >= l; i--) {
               res[++index] = matrix[b][i];
           }
           if (--b<t)break;

           for (int i = b; i >= t; i--) {
               res[++index] = matrix[i][l];
           }
           if (++l>r)break;

       }

       return Arrays.asList(res);
    }


}
