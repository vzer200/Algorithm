package sf;

import java.util.HashMap;
import java.util.Objects;

public class E290 {

    public boolean wordPattern(String s, String t) {
        //s映射到t
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        String[] s1 = t.split(" ");
        if (s1.length!=s.length()){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            String ss = s1[i];
            if (map1.containsKey(cs)&& !Objects.equals(map1.get(cs), ss) ||
                map2.containsKey(ss)&&map2.get(ss) !=cs) {
                return false;
            }
            map1.put(cs,ss);
            map2.put(ss,cs);

        }

        return true;

    }

}
