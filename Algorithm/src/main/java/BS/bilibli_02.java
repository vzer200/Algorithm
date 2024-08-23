package BS;

import java.util.Scanner;

public class bilibli_02 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String numStr = scanner.nextLine(); // 读取第一行输入，即数字字符串
            long k = scanner.nextLong(); // 读取第二行输入，即给定的整数k

            int count = 0;

            // 遍历所有可能的子字符串
            for (int i = 0; i < numStr.length(); i++) {
                long number = 0;
                for (int j = i; j < numStr.length(); j++) {
                    // 构建数字
                    number = number * 10 + (numStr.charAt(j) - '0');

                    // 如果构成的数字大于k，则退出循环
                    if (number >= k) {
                        break;
                    }

                    // 否则计数增加
                    count++;
                }
            }

            System.out.println(count);
        }

}
