package sf;

import java.util.Arrays;

public class E151 {
    //反转单词


    public static void main(String[] args) {

        String s = "  hello world  ";
        String s1 = reverseWords(s);
        System.out.println(s1);


    }


    //快慢指针法
    public static String reverseWords(String s) {

        char[] chars = s.toCharArray();
        char[] newChar = removeExtraSpaces(chars);
        reverse(newChar, 0, newChar.length-1);
        reverseEachWord(newChar);


        return new String(newChar);
    }

    //去除多余空格
    public static char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        //fast表示当前字符
        //slow表示要将字符反转后放到的位置
        for (int fast = 0; fast < chars.length; fast++) {

            if (chars[fast] != ' ') {
                //找到了需要反转的字符
                if (slow != 0) {
                    //slow不为第一个位置的时候
                     chars[slow++] = ' ';
                }
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];

                }

            }

        }

        char[] newChar = new char[slow];
        System.arraycopy(chars,0,newChar,0,slow);

        return newChar;
    }

    public static void reverse(char[] s, int left, int right) {


        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;

        }


    }


    //反转内部的单个单词
    public static void reverseEachWord(char[] chars) {
        int index=0;
        for (int i = 0; i <= chars.length; i++) {

            if (i==chars.length||chars[i] == ' '){
                reverse(chars,index,i-1);
                index = i+1;
            }


        }


    }

}
