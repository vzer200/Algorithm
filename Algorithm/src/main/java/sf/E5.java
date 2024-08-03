package sf;

public class E5 {
    //最长回文子串
    static int left ;
    static int right ;
    public String longestPalindrome(String s) {
        left = 0;
        right = 0;
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length-1; i++) {
          hw(array,i,i);
          hw(array,i,i+1);

        }
        return new String(array,left,right+1-left);
    }


    public static void hw(char[] array,int i , int j){

        while (i>=0&&j<array.length&&array[i]==array[j]){
            i--;
            j++;
        }
        i++;
        j--;
        if (j-i>right-left){
            right = j;
            left = i;
        }

    }
}
