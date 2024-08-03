package sf;

import java.util.*;

public class E49 {
    //字母异位词分组
    /*public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map  = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            List<String> strings = map.get(s);
            if (strings==null){
               strings = new ArrayList<>();
               map.put(s,strings);
            }
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }*/


    public List<List<String>> groupAnagrams(String[] strs) {
        //字母异位词指排列顺序不同，但是字母完全相同的单词
        //字母在排序好之后都是一样的

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            List<String> list = map.get(s);
            if (list==null){
                list = new ArrayList<>();
                map.put(s,list);
            }
            list.add(str);
        }

        return new ArrayList<>(map.values());
    }


}
