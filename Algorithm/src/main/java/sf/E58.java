package sf;

public class E58 {
    public static int lengthOfLastWord(String s) {


        int count = s.length()-1;
        while (s.charAt(count)==' '){
            count--;
        }
        int res = 0;
        while (count>=0&&s.charAt(count)!=' '){
            res++;
            count--;
        }
        return res;
    }


}
