package sf;

import java.util.*;

public class E819 {
    //最常见的单词

    //求paragraph段落里出现最多的单词
    //先将段落的单词进行分割
    //将分割后的单词进行频率统计
    //返回频率最高且不是违禁词的单词
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Set<String> set = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : split) {
            if (!set.contains(key)) {
                Integer count = map.get(key);
                count = count == null ? 1 : ++count;
                map.put(key, count);
            }
        }
        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Integer value = e.getValue();
            if (value > max) {
                max = value;
                maxKey = e.getKey();
            }
        }
        return maxKey;
    }


}
