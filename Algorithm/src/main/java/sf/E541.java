package sf;

import java.util.Arrays;

public class E541 {
    //反转字符串||


    //给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
    public static String reverseStr(String s, int k) {

        char[] array = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {


            //给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
            if (i + k <= array.length)  //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
            {
                reverse(array, i, i + k-1);
                continue;
            }
            reverse(array,i,s.length()-1);
            //如果剩余字符少于 k 个，则将剩余字符全部反转。

        }
        return new String(array);
    }


    //从a开始到b，将之间的字符进行反转
    public static String reverse(char[] s, int left, int right) {


            while (left < right) {
                char t = s[left];
                s[left] = s[right];
                s[right] = t;
                left++;
                right--;

            }


        return Arrays.toString(s);
    }

    public static void main(String[] args) {

        String s ="abcdefg";//k=2
        String reverseStr = reverseStr(s, 2);
        System.out.println(reverseStr);


    }

}
