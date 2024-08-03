package BS;

import java.util.Scanner;

public class ZJ_06 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 二进制长度
        int k = input.nextInt(); // 操作次数
        String s = input.next(); // 输入的字符串

        // 经过k次操作后的结果
        String result = f(s, k);

        System.out.println(result);
    }


    public static String f(String s, int k) {
        int count = 0; // 已遍历的1的个数
        int index = -1;

        // 找到第k个1的位置
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                if (count == k) {
                    index = i;
                    break;
                }
            }
        }

        // 如果1的个数小于k，返回"0"，否则返回从第k个1之后的子串
        if (index == -1) {
            return "0";
        } else {
            String substring = s.substring(index + 1);
            String reversed = transformString(substring);
            return removeLeadingZeros(reversed);
        }
    }

    public static String transformString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '1') {
                sb.append('0');
            } else if (c == '0') {
                sb.append('1');
            }
        }
        return sb.toString();
    }


    public static String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }

    //1010

    //0101
    // 010






}
