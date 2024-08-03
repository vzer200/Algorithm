package sf;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E03 {

    private boolean aBoolean;

    //无重复的最长子串
    public int lengthOfLongestSubstring1(String s) {

        //abcabcbb
        int begin = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            //
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                //map中有当前字符,更新索引
                begin = Math.max(begin, map.get(c) + 1);
                map.put(c, end);

            } else {
                map.put(c, end);
            }
            maxLength = Math.max(maxLength, end - begin + 1);

        }
        return maxLength;
    }


    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;//结果
        for (int end = 0; end < array.length; end++) {
            char c = array[end];
            while (set.contains(c)) {
                set.remove(array[start]);
                start++;
            }
            set.add(array[end]);
            res = Math.max(res, end - start + 1);

        }


        return res;
    }

    //修改一下这个题，返回最长字串
    public static String lengthOfLongestSubstring_(String s) {
        int start = 0;
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        String res = null;//结果
        int maxLength = 0;
        for (int end = 0; end < array.length; end++) {
            char c = array[end];
            while (set.contains(c)) {
                set.remove(array[start]);
                start++;
            }
            set.add(array[end]);

            if(end-start+1>maxLength){
                maxLength = end-start+1;
                res = new String(array,start,maxLength);
            }

        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_("abcabcbb"));
    }


}
