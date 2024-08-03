package sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E17 {
    //电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        //映射数字和字母
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        reverse(digits,map,0,res,sb);
        return res;
    }

    public void reverse(String digits, Map<Character, String> map, int index, List<String> res, StringBuilder sb){
        if (index==digits.length()){
            res.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            sb.append(c1);
            reverse(digits,map,index+1,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
