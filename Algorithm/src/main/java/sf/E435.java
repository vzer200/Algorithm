package sf;

import java.util.Arrays;
import java.util.Comparator;

public class E435 {
    //无重叠区间
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //贪心思路：寻找最优解方案
        //寻找结束时间最小的
        int count = 1;//记录需要不需要移除
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int right = intervals[0][1];//排完序后第一个肯定是最小结束时间的
        for (int i = 1; i < intervals.length; i++) {
            //从1开始后面的最小结束时间
            if (intervals[i][0]>=right){
                //开始时间大于第一个结束时间,表示有效会议，不用移除
                count++;
                right = intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}
