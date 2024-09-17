package BS;

import java.util.Scanner;

public class J360_01 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt();
        int[][] customers = new int[n][2]; 

        for (int i = 0; i < n; i++) {
            customers[i][0] = sc.nextInt();
            customers[i][1] = sc.nextInt();
        }

        int max = 0;
        int totalSubsets = 1 << n; 

        for (int mask = 0; mask < totalSubsets; mask++) {
            int customersInSubset = Integer.bitCount(mask);
            
            if (customersInSubset <= max) {
                continue;
            }

            boolean[] usedDrinks = new boolean[m + 1]; 
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { 
                    int drink1 = customers[i][0];
                    int drink2 = customers[i][1];
                    
                    if (usedDrinks[drink1] || usedDrinks[drink2]) {
                        valid = false;
                        break;
                    }
                    
                    usedDrinks[drink1] = true;
                    usedDrinks[drink2] = true;
                }
            }

            if (valid) {
                max = customersInSubset;
            }
        }

        System.out.println(max);
    }*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 读取顾客数量 n
        int m = sc.nextInt(); // 读取酒的编号范围 m

        int[][] customers = new int[n][2]; // 创建二维数组，存储每个顾客想要的两种酒

        // 读取每个顾客的需求
        for (int i = 0; i < n; i++) {
            customers[i][0] = sc.nextInt(); // 第一个酒的编号
            customers[i][1] = sc.nextInt(); // 第二个酒的编号
        }

        int max = 0; // 记录最多能满足的顾客数量

        int totalSubsets = 1 << n; // 计算所有可能的顾客组合，总共有 2^n 个

        // 枚举所有可能的顾客组合
        for (int mask = 0; mask < totalSubsets; mask++) {
            int customersInSubset = Integer.bitCount(mask); // 当前组合中的顾客数量

            // 如果当前组合的顾客数量不超过已找到的最大值，跳过
            if (customersInSubset <= max) {
                continue;
            }

            boolean[] usedDrinks = new boolean[m + 1]; // 标记哪些酒已经被使用，数组大小为 m+1，方便直接使用酒的编号作为索引
            boolean valid = true; // 标记当前组合是否有效

            // 检查当前组合中的每个顾客
            for (int i = 0; i < n; i++) {
                // 判断顾客 i 是否在当前组合中
                if ((mask & (1 << i)) != 0) {
                    int drink1 = customers[i][0]; // 顾客想要的第一个酒
                    int drink2 = customers[i][1]; // 顾客想要的第二个酒

                    // 检查这两种酒是否已经被其他顾客占用
                    if (usedDrinks[drink1] || usedDrinks[drink2]) {
                        valid = false; // 如果有冲突，标记为无效组合
                        break; // 退出循环，不再检查剩余的顾客
                    }

                    // 标记这两种酒为已使用
                    usedDrinks[drink1] = true;
                    usedDrinks[drink2] = true;
                }
            }

            // 如果当前组合有效，且满足的顾客数量超过当前最大值，更新最大值
            if (valid) {
                max = customersInSubset;
            }
        }

        // 输出最多能满足的顾客数量
        System.out.println(max);
    }*/


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] customers = new int[n][2];

        for (int i = 0; i < n; i++) {
            customers[i][0] = sc.nextInt();
            customers[i][1] = sc.nextInt();
        }

        boolean[] usedDrinks = new boolean[m + 1];

        int max = dfs(0, 0, customers, usedDrinks);

        System.out.println(max);
    }


    public static int dfs(int index, int count, int[][] customers, boolean[] usedDrinks) {
        if (index == customers.length) {
            return count;
        }

        int max = count;

        int drink1 = customers[index][0];
        int drink2 = customers[index][1];

        if (!usedDrinks[drink1] && !usedDrinks[drink2]) {
            usedDrinks[drink1] = true;
            usedDrinks[drink2] = true;

            int withCurrent = dfs(index + 1, count + 1, customers, usedDrinks);

            if (withCurrent > max) {
                max = withCurrent;
            }

            usedDrinks[drink1] = false;
            usedDrinks[drink2] = false;
        }

        int withoutCurr = dfs(index + 1, count, customers, usedDrinks);

        if (withoutCurr > max) {
            max = withoutCurr;
        }

        return max;
    }
}
