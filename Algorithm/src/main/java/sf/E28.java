package sf;

import java.util.Arrays;
import java.util.List;

public class E28 {
    //找出字符串中第一个匹配的下标
    public int strStr(String str1, String str2) {
        String[] s = str1.split(" ");
        List<String> list = Arrays.asList(s);


        //str2在str1中出现
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int i = 0; //str1的起始点
        int j = 0;
        while (i<=charArray1.length-charArray2.length){
            for ( j = 0; j < charArray2.length; j++) {
                if (charArray1[i+j]!=charArray2[j]){
                    break;
                }
            }

            if (charArray2.length==j){
                return i;
            }
            i++;

        }

        return -1;
    }









    public static boolean isPalindrome(String s) {


        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='a'&& c<='z'){
                sb.append(c);
            }else if(c>='A'&&c<='Z'){
                c+=32;
                sb.append(c);
            }else if (c>='0'&&c<='9'){
                sb.append(c);
            }

        }
        String res = sb.toString();
        for(int i = 0; i<res.length();i++){
            if(res.charAt(i)!=res.charAt(res.length()-1-i)){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        boolean subsequence = isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }


    public static boolean isSubsequence(String s, String t) {
        //s是否为t子序列
        int count = 0;
        for (int i = 0 ,j= 0; j < t.length(); j++) {

            if (s.charAt(i) ==t.charAt(j)){
                count++;
                i++;
            }



        }

        return count==s.length();
    }

}
