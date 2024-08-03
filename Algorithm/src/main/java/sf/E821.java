package sf;

import java.util.Arrays;

public class E821 {


    public static int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        int[] count = new int[s.length()];
        int index = 0;
        Arrays.fill(res,100);
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==c){
                count[index++] = i;
            }
        }

        for(int i =0;i<s.length();i++){

            for(int j = 0;j<index;j++){
                res[i] = Math.min(res[i],Math.abs(count[j]-i));
            }

        }

        return res;
    }

    public static void main(String[] args) {
        shortestToChar("loveleetcode",'e');
    }

}
