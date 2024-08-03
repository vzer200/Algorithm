package sf;

import java.util.*;

public class J36201 {

    public static void main(String[] args) {

        List<List<Integer>> nums1 = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(5, 8)
        );
        // 调用 numberOfPoints 方法
        int result = numberOfPoints(nums1);
        System.out.println(result);
        // 验证结果是否符合预期

    }

    public static int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> coveredPoints = new HashSet<>();
        for (List<Integer> interval : nums) {
            for (int i = interval.get(0); i <= interval.get(1); i++) {
                coveredPoints.add(i);
            }
        }
        return coveredPoints.size();
    }

}
