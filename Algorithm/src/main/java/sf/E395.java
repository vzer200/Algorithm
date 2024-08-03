package sf;

import java.util.HashMap;
import java.util.Map;

public class E395 {
    //至少有k个重复字符的最长字串
    public static int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }
    public static void main(String[] args) {

        System.out.println(longestSubstring("abbcce", 2)); // 3

    }
    public int longestSubstring2(String s, int k) {
        if (s.length() < k)
            return 0;
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                Integer value = map.get(c);
                map.put(c,++value);
            }else {
                map.put(c, 1);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character)<k){
                //如果小于频率k，切开
                int res = 0;
                for (String c : s.split(String.valueOf(character))) {

                     res = Math.max(res, longestSubstring2(c, k));

                }
                return res;
            }

        }
        return s.length();
    }
}
