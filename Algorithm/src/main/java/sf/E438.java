package sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E438 {

    //给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen<pLen){
            return new ArrayList<>();
        }
        //先计算前面plen个字符的频次
        int[] sCont = new int[26];
        int[] pCont = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCont[s.charAt(i)-'a']++;
            pCont[p.charAt(i)-'a']++;
        }
        //前面plen相同的话直接加进去
        if (Arrays.equals(pCont,sCont)){
            res.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            //滑动窗口逻辑
            sCont[s.charAt(i-pLen)-'a']--;
            sCont[s.charAt(i)-'a']++;
            if (Arrays.equals(sCont,pCont)){
                res.add(i-pLen+1);
            }

        }
        return res;
    }

    private static boolean check(int left, int right, String s, String p) {
        //怎么判断是否是p的异位词字串
        // abc  bca 哈希表
        // a-"a" = 0;
        int[] hash = new int[26];
        String newS = s.substring(left, right + 1);
        for (int i = 0; i < newS.length(); i++) {
          //  char c1 = newS.charAt(i);
          //  char c2 = p.charAt(i);
            hash[newS.charAt(i)-'a']++;
            hash[p.charAt(i)-'a']--;

        }

        for(int i = 0; i<26; i++){
            if(hash[i]!=0)
                return false;
        }
        return true;

    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String    p = "abc";
        findAnagrams(s,p);
    }


    /*public List<Integer> findAnagrams2(String s, String p) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
    }*/
}
