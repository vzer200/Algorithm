package sf;

import java.util.HashMap;

public class E13 {
    public static int romanToInt(String s) {

        HashMap<Character,Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int sum  = 0;
        //除了特殊情况外，小的数字在大的数字右边
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            Integer value = map.get(c);
            if (i<s.length()-1&&map.get(s.charAt(i+1))>value){
                sum -= value;
            }else {
                sum+= value;
            }
        }



        return sum;
    }


    public static void main(String[] args) {
        String s= "III";
        romanToInt(s);
    }

}
