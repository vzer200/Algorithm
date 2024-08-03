package sf;

public class E14 {
    //最长公共前缀
    // i
    //j
    public static String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length()==i||strs[j].charAt(i)!=str.charAt(i)){
                    return new String(str.toCharArray(),0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        longestCommonPrefix(s);
    }

}
