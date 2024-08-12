package AlgorithmSearch;

import java.util.*;

public class PasswordAttempts {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> passwordSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            passwordSet.add(scanner.nextLine());
        }

        List<String> passwords = new ArrayList<>(passwordSet);
        Collections.sort(passwords, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });

        String targetPassword = passwords.get(0);
        int targetPasswordCount = 0;
        int shorterCount = 0;

        for (String password : passwords) {
            if (password.equals(targetPassword)) {
                targetPasswordCount++;
            } else if (password.length() < targetPassword.length()) {
                shorterCount++;
            }
        }

        int minAttempts = shorterCount + 1; // 最小尝试次数
        int maxAttempts = shorterCount + targetPasswordCount; // 最大尝试次数

        System.out.println(minAttempts + " " + maxAttempts);
    }*/

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取测试用例数量
        int t = scanner.nextInt();

        while (t-- > 0) {
            // 读取n, k, x
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();

            int[] arr = new int[n];
            Set<Integer> set = new HashSet<>();

            // 读取数组并将所有元素存入集合中
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                set.add(arr[i]);
            }

            // 找到集合中不存在的最小MEX
            int mex = 0;
            while (set.contains(mex)) {
                mex++;
            }

            // 计算直接删除的花费
            int cost1 = x * k;

            // 如果MEX < x，计算执行一次操作一后的花费
            int cost2 = Integer.MAX_VALUE;
            if (mex < x) {
                // 执行一次操作一，将MEX对应元素从集合中移除
                for (int i = 0; i < n; i++) {
                    if (arr[i] == mex) {
                        set.remove(arr[i]);
                        break;
                    }
                }

                // 重新计算新的MEX
                mex = 0;
                while (set.contains(mex)) {
                    mex++;
                }

                // 计算执行一次操作一后的花费
                cost2 = x + mex * k;
            }

            // 输出两个花费中的最小值
            System.out.println(Math.min(cost1, cost2));
        }
        scanner.close();
    }*/

    private static int calculateMinCost(int[] arr, int n, int k, int x) {
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            int currentMex = minMEX(arr, i, n);
            int currentCost = x * i + currentMex * k;
            minCost = Math.min(minCost, currentCost);
            if (i < n) {
                // 删除第一个元素并将其值加到第k个元素
                arr[k - 1] += arr[i];
            }
        }

        return minCost;
    }

    private static int minMEX(int[] arr, int start, int n) {
        boolean[] found = new boolean[n + 1];
        for (int i = start; i < n; i++) {
            if (arr[i] < n) {
                found[arr[i]] = true;
            }
        }
        for (int i = 0; i <= n; i++) {
            if (!found[i]) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int q = scanner.nextInt();


        int[] ribbon = new int[n];
        for (int i = 0; i < n; i++) {
            ribbon[i] = scanner.nextInt();
        }


        for (int i = 0; i < q; i++) {
            String direction = scanner.next();
            int length = scanner.nextInt();


            Set<Integer> distinctColors = new HashSet<>();
            if (direction.equals("L")) {
                for (int j = 0; j < length; j++) {
                    int index = j % n;
                    distinctColors.add(ribbon[index]);
                }
            } else if (direction.equals("R")) {
                for (int j = 0; j < length; j++) {
                    int index = (n - length + j) % n;
                    distinctColors.add(ribbon[index]);
                }
            }


            System.out.println(distinctColors.size());
        }

        scanner.close();
    }
}




