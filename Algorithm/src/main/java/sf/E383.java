package sf;

import java.util.HashMap;

public class E383 {

    public boolean canConstruct(String a, String b) {
        //a是否能由b里面的字符构成
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
           map.put(c,map.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

}
