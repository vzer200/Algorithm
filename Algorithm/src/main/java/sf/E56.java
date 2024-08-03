package sf;

import org.springframework.util.LinkedMultiValueMap;

import java.util.*;

public class E56 {
    public static int[][] merge(int[][] intervals) {

        //重叠区间的概念：如果当前的左端点大于结果区间的右端点，那么表示这两个区间有重叠部分
        //返回覆盖重叠区间的值
        //取这两个区间的最大最小值作为新区间的范围
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; //
            }
        });//运用比较器进行排序 如果o1[0]小于o2[0]返回负数 表示o1应该在o2后面 如果相等表示不动

        int[][] res = new int[intervals.length][2]; // 2表示一维数组的长度为 2 intervals.length表示这个二维数组的长度
        int index = -1;
        for (int[] interval : intervals) {
            //区间内的每个数组
            if (index==-1||res[index][1]<interval[0]){
                //表示不是重叠区间 直接加入原始数组
                res[++index] = interval;
            }else {
                //表示重叠区间 进行覆盖逻辑
                res[index][1] = Math.max(res[index][1],interval[1]);
            }

        }

        //这里复制数组是因为覆盖之后数组的个数会变少，个数可以用index的值确定
        return Arrays.copyOf(res, index + 1);
    }

    public static void main(String[] args) {

        int[][] intervals = {{1,4},{2,3}};
        merge(intervals);

    }


    public int[][] merge2(int[][] intervals) {

        //合并重叠区间
        //先将数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int index = -1;
        int[][] res = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (index==-1||res[index][1]<interval[0]){
                res[++index] = interval;
            }else{
                res[index][1] = Math.max(interval[1],res[index][1]);
            }
        }

        return Arrays.copyOf(res,index+1);
    }






    public int[][] merge3(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //合并区间
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            //如果结果数组的右端点小于当前数组的左端点 直接加入
            //
            if (index==-1||res[index][1]<interval[0]){
                res[++index] = interval;
            }else {
                //有重叠区间
                //从当前数组的右端点和结果数组的右端点取其中最大值对结果数组进行替换
                res[index][1]=Math.max(interval[1],res[index][1]);
            }
        }

        return Arrays.copyOf(res,index+1);
    }



    public int[][] merge4(int[][] intervals) {
        //合并区间
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int index= -1;
        int[][] res = new int[intervals.length][2];
        for (int[] interval : intervals) {
            //如果结果数组的右端点小于当前数组的左端点 表示没有重叠区间 直接加入
            if (index==-1||res[index][1]<interval[0]){
                res[++index]= interval;
            }else {
                //表示有重叠区间
                //从当前数组的右端点和结束数组的右端点取最大值
                res[index][1] = Math.max(res[index][1],interval[1]);
            }

        }

        return Arrays.copyOf(res,index+1);
    }

}
