package BS;

import java.util.TreeMap;

public class CVTE_02 {
    public boolean isTrue(int[][] intervals, int maxResource) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int resource = interval[2];


            map.put(start, map.getOrDefault(start, 0) + resource);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - resource);
        }

        int currentResource = 0;
        for (int change : map.values()) {
            currentResource += change;
            if (currentResource > maxResource) {
                return false;
            }
        }

        return true; 
    }

    public static void main(String[] args) {
        CVTE_02 solution = new CVTE_02();
        int[][] intervals = {{1, 4, 2}, {2, 5, 1}, {2, 4, 1}, {4, 7, 1}};
        int maxResource = 3;
        System.out.println(solution.isTrue(intervals, maxResource)); // 输出: false
    }
}
