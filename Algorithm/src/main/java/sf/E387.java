package sf;

public class E387 {
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        char[] charArray = s.toCharArray();//得到字符数组
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            array[c-97]++;
        }
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (array[c-97]==1){
                return i;
            }
        }
        return -1;

    }
}
