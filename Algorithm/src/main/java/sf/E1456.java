package sf;

import java.util.HashMap;
import java.util.Map;

public class E1456 {

    public static int maxVowels(String s, int k) {
        int left = 0;
        char[] array = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('e',0);
        map.put('i',0);
        map.put('o',0);
        map.put('u',0);
        int max = 0;
        for(int right = 0; right<k;right++){
            //未构成窗口
            char c = array[right];
            if(map.containsKey(c)){
                max += map.get(c) + 1;
            }

        }
        int maxValue = 0;

        for(int right = k; right<array.length;right++){
            if(right-left+1>k){
                maxValue = Math.max(max,maxValue);
                boolean flag = map.containsKey(array[left]);
                if(flag){
                    max-=1;
                }
                left++;
            }
            if(map.containsKey(array[right])){
                max += map.get(array[right]) + 1;
            }


        }

        return maxValue;

    }

    public static void main(String[] args) {
        String s = "weallloveyou";
        int k = 7;
        maxVowels(s,k);
    }

}
