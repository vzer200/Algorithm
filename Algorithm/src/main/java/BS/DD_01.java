package BS;

import java.util.Scanner;

public class DD_01 {
    static int maxBeauty = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // Number of slots on the shelf
            int m = scanner.nextInt(); // Number of items

            if (n == 1 || m == 0) {
                // If only one slot or no items, beauty is 0
                System.out.println(0);
                continue;
            }

            maxBeauty = 0;
            backtrack(new int[m], 0, n, m);
            System.out.println(maxBeauty);
        }

        scanner.close();
    }

    private static void backtrack(int[] arrangement, int index, int n, int m) {
        if (index == m) {
            maxBeauty = Math.max(maxBeauty, calculateBeauty(arrangement));
            return;
        }

        for (int i = 1; i <= n; i++) {
            arrangement[index] = i;
            backtrack(arrangement, index + 1, n, m);
        }
    }

    // Calculate the beauty of the arrangement
    private static int calculateBeauty(int[] arrangement) {
        int beauty = 0;
        for (int i = 1; i < arrangement.length; i++) {
            beauty += Math.abs(arrangement[i] - arrangement[i - 1]);
        }
        return beauty;
    }
}
