package BS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ZJ_05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // 使用Map来记录每棵树上对应高度的苹果数量
        Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            int pos = sc.nextInt();
            int hi = sc.nextInt();

            if(!map.containsKey(pos)) {
                map.put(pos, new TreeMap<>());
            }

            TreeMap<Integer, Integer> heightMap = map.get(pos);
            heightMap.put(hi, heightMap.getOrDefault(hi, 0) + 1);
        }

        int result = 0;
        for(TreeMap<Integer, Integer> heightMap : map.values()) {
            int[] heights = new int[101];

            for(Map.Entry<Integer, Integer> entry : heightMap.entrySet()) {
                heights[entry.getKey()] = entry.getValue();
            }

            int max = 0;
            for(int i = 1; i <= 100 - k + 1; i++) {
                int sum = 0;
                for(int j = i; j < i + k; j++) {
                    sum += heights[j];
                }
                max = Math.max(max, sum);
            }
            result += max;
        }

        System.out.println(result);
    }

}
