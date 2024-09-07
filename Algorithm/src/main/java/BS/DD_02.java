package BS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DD_02 {
    static int[][] cost;
    static Map<String, Integer> memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();


        cost = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();


        String s = scanner.nextLine();


        memo = new HashMap<>();


        int minCost = calculateMinCost(s);


        System.out.println(minCost);

        scanner.close();
    }


    private static int calculateMinCost(String s) {

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        if (s.length() <= 1) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            String newString = s.substring(0, i) + s.substring(i + 2); // 删除这两个字符

            int currentCost = cost[a - 'a'][b - 'a'];

            int remainingCost = calculateMinCost(newString);

            minCost = Math.min(minCost, currentCost + remainingCost);
        }

        memo.put(s, minCost);
        return minCost;
    }

}
