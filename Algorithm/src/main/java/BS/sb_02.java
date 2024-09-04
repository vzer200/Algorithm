package BS;

import java.util.ArrayList;
import java.util.List;

public class sb_02 {
    public static int chooseBestSum(int t, int k, List<Integer> ls) {
        List<Integer> possibleSums = new ArrayList<>();
        combine(ls, k, 0, new ArrayList<>(), possibleSums);

        int bestSum = -1;
        for (int sum : possibleSums) {
            if (sum <= t && sum > bestSum) {
                bestSum = sum;
            }
        }
        return bestSum == -1 ? 0 : bestSum;
    }

    private static void combine(List<Integer> ls, int k, int start, List<Integer> current, List<Integer> possibleSums) {
        if (current.size() == k) {
            // 使用传统 for-each 循环计算总和
            int sum = 0;
            for (Integer num : current) {
                sum += num;
            }
            possibleSums.add(sum);
            return;
        }

        for (int i = start; i < ls.size(); i++) {
            current.add(ls.get(i));
            combine(ls, k, i + 1, current, possibleSums);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> distances = List.of(50, 55, 56, 57, 58);
        System.out.println(chooseBestSum(163, 3, distances)); // 输出: 163

        distances = List.of(50);
        System.out.println(chooseBestSum(163, 3, distances)); // 输出: 0

        distances = List.of(91, 74, 73, 85, 73, 81, 87);
        System.out.println(chooseBestSum(230, 3, distances)); // 输出: 228
    }
}
